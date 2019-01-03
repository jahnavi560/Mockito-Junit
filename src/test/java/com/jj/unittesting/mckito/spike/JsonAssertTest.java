package com.jj.unittesting.mckito.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String actualResponse = "{\"id\":1,\"name\":\"item1\",\"price\":10,\"quantity\":100}";
	String actualResponse_withSpace = "{\"id\":1,\"name\":\"item 1\",\"price\":10,\"quantity\":100}";
	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpace() throws JSONException {
		String expectedResponse ="{\"id\":1,\"name\":\"item1\",\"price\":10, \"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse , actualResponse, true);
	}
	
	@Test
	public void jsonAssert_StrictFalse_LessParam() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"item1\",\"price\":10}";
		JSONAssert.assertEquals(expectedResponse , actualResponse, false);
	}
	//Failed
	/*@Test
	public void jsonAssert_StrictFalse_DifferentValue() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"item1\",\"price\":10,\"quantity\":1}";
		JSONAssert.assertEquals(expectedResponse , actualResponse, false);
	}*/
	
	//"" used for spaced in value like name here
	@Test
	public void jsonAssert_StrictFalseOrTrue_WithoutDoubleQuote() throws JSONException {
		String expectedResponse ="{id:1,name:\"item 1\",price:10, quantity:100}";
		JSONAssert.assertEquals(expectedResponse , actualResponse_withSpace, true);
	}
}
