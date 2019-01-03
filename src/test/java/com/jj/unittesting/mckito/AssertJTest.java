package com.jj.unittesting.mckito;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertJTest {
	
	@Test
	public void learn() {
		List<Integer> list = Arrays.asList(1,2,3);
		//assertThat(list, hasSize(3));
		
		assertThat(list).hasSize(3)
			.contains(2)
			.allMatch( x -> x>0)
			.allMatch( x -> x<10);
		
		
		
	}

}
