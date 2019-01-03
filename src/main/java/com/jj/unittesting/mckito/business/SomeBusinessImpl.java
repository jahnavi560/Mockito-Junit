package com.jj.unittesting.mckito.business;
import java.util.Arrays;

public class SomeBusinessImpl {

	private SomeDataService someDataService;
	

	public SomeDataService getSomeDataService() {
		return someDataService;
	}

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {

		return Arrays.stream(data).reduce(Integer :: sum).orElse(0);
		/*int sum = 0;
		for(int value : data) {
			sum += value;
		}
		return sum;*/
	}
	
	public int calculateSumByRetriveData() {
		
		return Arrays.stream(someDataService.retriveData()).reduce(Integer :: sum).orElse(0);
		/*int[] data = someDataService.retriveData() ;
		int sum = 0;
		for(int value : data) {
			sum  += value;
		}
		return sum;*/
	}
}
