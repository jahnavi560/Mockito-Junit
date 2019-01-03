package com.jj.unittesting.mckito.item;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javassist.ClassPath;

//to check proper integration through different layers

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations= {"classpath:"})
public class ItemControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void contextLoads() throws JSONException {
		String  respose = testRestTemplate.getForObject("/item-from-db",String.class);
		JSONAssert.assertEquals("[{id:1001},{id:1002}]", respose, false);
	}

}
