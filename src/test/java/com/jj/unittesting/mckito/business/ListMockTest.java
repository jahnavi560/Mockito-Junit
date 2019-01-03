package com.jj.unittesting.mckito.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {
	List<String> mockList = mock(List.class);
	
	@Test
	public void mockListSize() {

		when(mockList.size()).thenReturn(5);
		assertEquals(5, mockList.size());
	}
	
	@Test
	public void mockListDifferentSize() {

		when(mockList.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mockList.size());
		assertEquals(10, mockList.size());
	}
	//Default value for element null
	@Test
	public void mockListPassParameter() {

		when(mockList.get(0)).thenReturn("jj");
		assertEquals("jj", mockList.get(0));
		assertEquals(null, mockList.get(1));
	}
	@Test
	public void mockListPassGenericParameter() {

		when(mockList.get(anyInt())).thenReturn("jj");
		assertEquals("jj", mockList.get(0));
		assertEquals("jj", mockList.get(1));
	}
	
	@Test
	public void basicVerification() {
		String value1 = mockList.get(0);
		String value2 = mockList.get(1);
		
		verify(mockList).get(0);
		verify(mockList).get(1);
		verify(mockList, atLeastOnce()).get(0);
		verify(mockList, atLeast(1)).get(0);
		verify(mockList, atMost(2)).get(1);
		verify(mockList, never()).get(2);
	}
	@Test
	public void argumentCapturing() {
		mockList.add("jj");
		
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		verify(mockList).add(argumentCaptor.capture());
		assertEquals("jj", argumentCaptor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing() {
	
		mockList.add("j1");
		mockList.add("j2");
		
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		verify(mockList,times(2)).add(argumentCaptor.capture());
		assertEquals("j1", argumentCaptor.getAllValues().get(0));
		assertEquals("j2", argumentCaptor.getAllValues().get(1));
	}

	//Works as Mock class, return value only which are set as when then
	//@Test
	public void mocking() {
		
		ArrayList<String> mockArrayList = mock(ArrayList.class);
		System.out.println( mockArrayList.size()); //0
		System.out.println(mockArrayList.get(0)); //null
		
		mockArrayList.add("j1");
		mockArrayList.add("j2");
		System.out.println( mockArrayList.size()); //0
		System.out.println(mockArrayList.get(0)); //null
		
		when(mockArrayList.size()).thenReturn(5);
		when(mockArrayList.get(0)).thenReturn("j1");
		System.out.println( mockArrayList.size()); //5
		System.out.println(mockArrayList.get(0)); //j1
	}
	//Spy class worked as orignal class. used when to check orignal object not mock
	@Test
	public void spying() {
		
		ArrayList<String> mockArrayList = spy(ArrayList.class);
	//	System.out.println( mockArrayList.size()); exception throws
		
		mockArrayList.add("j1");
		mockArrayList.add("j2");
		System.out.println( mockArrayList.size()); //2
		System.out.println(mockArrayList.get(0)); //j1
		
		when(mockArrayList.size()).thenReturn(5);
		when(mockArrayList.get(0)).thenReturn("j3");
		System.out.println( mockArrayList.size()); //5
		System.out.println(mockArrayList.get(0)); //j1
	}
}
