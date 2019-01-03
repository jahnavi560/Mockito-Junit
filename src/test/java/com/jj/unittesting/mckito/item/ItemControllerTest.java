package com.jj.unittesting.mckito.item;

import static org.mockito.Mockito.when;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.jj.unittesting.mckito.ItemController;
import com.jj.unittesting.mckito.Model.Item;
import com.jj.unittesting.mckito.business.ItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
 
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemService itemService;
	
	@Test
	public void basiTest() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{\"id\": 1,\"name\":\"item1\",\"price\":10,\"quantity\":100}"))
				.andReturn();
		
		//JSONAssert.assertEquals("{\"id\": 1,\"name\":\"item1\",\"price\":10,\"quantity\":100}", result.getResponse().getContentAsString(), false);
					}
	
	@Test
	public void retriveFromServiceTest() throws Exception {
		
		when(itemService.retriveItem()).thenReturn(new Item(2,"item2",20,200));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-from-service")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{id:2,name:item2,price:20,quantity:200}"))
				.andReturn();
					}
	
	@Test
	public void retriveFromDBTest() throws Exception {
		
		when(itemService.retriveAllItemFromDB()).thenReturn(Arrays.asList(new Item(2,"item2",20,200),new Item(3,"item3",30,300)));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-from-db")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("[{id:2,name:item2,price:20,quantity:200},{id:3,name:item3,price:30,quantity:300}]"))
				.andReturn();
		
	}
}
