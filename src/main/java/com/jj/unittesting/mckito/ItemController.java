package com.jj.unittesting.mckito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jj.unittesting.mckito.Model.Item;
import com.jj.unittesting.mckito.business.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/item")
	public Item getItems() {
		return new Item(1, "item1", 10, 100);
	}
	@GetMapping("/item-from-service")
	public Item retriveFromService() {
		return itemService.retriveItem();
	}
	
	@GetMapping("/item-from-db")
	public List<Item> retriveFromDB() {
		return itemService.retriveAllItemFromDB();
	}
}
