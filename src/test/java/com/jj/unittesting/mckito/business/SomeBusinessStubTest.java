package com.jj.unittesting.mckito.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class SomeDataServiceStub implements SomeDataService{
	@Override
	public int[] retriveData() {
		return new int[] {5,6,7};
	}
}
class EmptyDataServiceStub implements SomeDataService{
	@Override
	public int[] retriveData() {
		return new int[] {};
	}
}
class OneElementServiceStub implements SomeDataService{
	@Override
	public int[] retriveData() {
		return new int[] {5};
	}
}
public class SomeBusinessStubTest {
	
	@Test
	public void calculateSum_Basic() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		businessImpl.setSomeDataService(new SomeDataServiceStub());
		int actualResult = businessImpl.calculateSumByRetriveData();
		int expectedResult = 18;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSum_Empty() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		businessImpl.setSomeDataService(new EmptyDataServiceStub());
		int actualResult = businessImpl.calculateSumByRetriveData();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSum_OneValue() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		businessImpl.setSomeDataService(new OneElementServiceStub());
		int actualResult = businessImpl.calculateSumByRetriveData();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}

}
