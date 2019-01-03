package com.jj.unittesting.mckito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)

public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	
	@Test
	public void basicHelloWorldTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello World"))
				.andReturn();
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}

}
