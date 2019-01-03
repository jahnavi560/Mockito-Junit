package com.jj.unittesting.mckito.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SomeBusinessTest {
	
	@Test
	public void calculateSum_Basic() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		int actualResult = businessImpl.calculateSum(new int[] {1,2,3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	} 
	@Test
	public void calculateSum_Empty() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		int actualResult = businessImpl.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSum_OneValue() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		int actualResult = businessImpl.calculateSum(new int[] {1});
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);
	}

}
