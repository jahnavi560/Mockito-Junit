package com.jj.unittesting.mckito.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jj.unittesting.mckito.Data.ItemRepository;
import com.jj.unittesting.mckito.Model.Item;
@Component
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	
	public Item retriveItem() {
		return new Item(2, "item2", 20, 200);
	}
	
	public List<Item> retriveAllItemFromDB() {
		ItemRepository itemRepository2 = itemRepository;
		List<Item> items = itemRepository2.findAll();
		for(Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;
	}

}
