package com.jj.unittesting.mckito.item;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.jj.unittesting.mckito.Data.ItemRepository;
import com.jj.unittesting.mckito.Model.Item;
import com.jj.unittesting.mckito.business.ItemService;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {
	@InjectMocks
	private ItemService itemService;
	
	@Mock
	private ItemRepository itemRepository;

	@Test
	public void retriveAllItemFromDBTest() {
		Mockito.when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(2,"item2",20,200),new Item(3,"item3",30,300)));
		List<Item> items =  itemService.retriveAllItemFromDB();
		assertEquals(items.get(0).getValue(), 4000);
		assertEquals(items.get(1).getValue(), 9000);
	}
	
	@Test
	public void retriveItem() {
			assertEquals(2,itemService.retriveItem().getId());
	}

}
