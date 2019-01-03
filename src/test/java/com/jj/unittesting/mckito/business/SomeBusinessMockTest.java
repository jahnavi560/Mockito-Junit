package com.jj.unittesting.mckito.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
	@InjectMocks
	SomeBusinessImpl businessImpl;
	@Mock
	SomeDataService dataServiceMock = mock(SomeDataService.class);
	
	
	@Test
	public void calculateSum_Basic() {
		
		when(dataServiceMock.retriveData()).thenReturn(new int[] {5,6,7});
		assertEquals(18, businessImpl.calculateSumByRetriveData());
	}
	@Test
	public void calculateSum_Empty() {
		
		when(dataServiceMock.retriveData()).thenReturn(new int[] {});
		assertEquals(0, businessImpl.calculateSumByRetriveData());
	}
	@Test
	public void calculateSum_OneValue() {
		
		when(dataServiceMock.retriveData()).thenReturn(new int[] {5});
		businessImpl.setSomeDataService(dataServiceMock);
		assertEquals(5, businessImpl.calculateSumByRetriveData());
	}
	
	
	/*Previous Code 
	  @Test
	public void calculateSum_Basic() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retriveData()).thenReturn(new int[] {5,6,7});
		businessImpl.setSomeDataService(dataServiceMock);
		int actualResult = businessImpl.calculateSumByRetriveData();
		int expectedResult = 18;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSum_Empty() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retriveData()).thenReturn(new int[] {});
		businessImpl.setSomeDataService(dataServiceMock);
		int actualResult = businessImpl.calculateSumByRetriveData();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void calculateSum_OneValue() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retriveData()).thenReturn(new int[] {5});
		businessImpl.setSomeDataService(dataServiceMock);
		int actualResult = businessImpl.calculateSumByRetriveData();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}*/

}
