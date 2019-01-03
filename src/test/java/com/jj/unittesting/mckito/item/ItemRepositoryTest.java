package com.jj.unittesting.mckito.item;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.jj.unittesting.mckito.Data.ItemRepository;
import com.jj.unittesting.mckito.Model.Item;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository itemReposiory;

	@Test
	public void findAllTest() {
		List<Item> items = itemReposiory.findAll();
		assertEquals(2, items.size());
	}
}
