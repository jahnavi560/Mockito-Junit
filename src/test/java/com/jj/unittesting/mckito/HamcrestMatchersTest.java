package com.jj.unittesting.mckito;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {
	
	@Test
	public void learn() {
		List<Integer> list = Arrays.asList(1,2,3);
		assertThat(list, hasSize(3));
		assertThat(list,hasItems(1,3));
		assertThat(list,everyItem(greaterThan(0)));
		assertThat(list,everyItem(lessThan(100)));
		
		assertThat("ABCDEF" , startsWith("ABC"));
		assertThat("ABCDEF" , endsWith("EF"));
	}

}
