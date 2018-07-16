package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class StringReverseTest extends SpringBootRestAPIApplicationTests{
	@Autowired
	private WebApplicationContext webApplicationContext;

	@SuppressWarnings("unused")
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testFibonacci() throws Exception {
		
	}

}
