package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.example.demo.service.impl.StringReverseService;

public class StringReverseTest1 {

	@InjectMocks
	StringReverseService service;

	@Before
	public void setup() {
		service = new StringReverseService();

	}

	@Test
	public void reverse_test() {
		String str = "how!#$^";
		String result = "^$#!woh";
		String reverse = service.reverse(str);
		assertEquals(reverse, result);

	}

	@Test
	public void fibonacci_test() {
		long n = 10;
		long result = 55;
		long fibseries = service.getFibSeries(n);
		assertEquals(result, fibseries);
	}

	@Test
	public void testThrowsIllegalArgumentException_fibonacci() {

		
		try {
			service.getFibSeries(0);
		} catch (IllegalArgumentException ex) {
			fail("Threw IllegalArgumentException for 0 but 0 is nonnegative: " + ex);
		}

		
		try {
			service.getFibSeries(1);
		} catch (IllegalArgumentException ex) {
			fail("Threw IllegalArgumentException for 1 but 1 is nonnegative: " + ex);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void expectedIllegalArgumentException() {
		service.getFibSeries(-1);
	}
	
	@Test
	public void triangle_test_Equilateral() {
		double a = 1;
		double b = 1;
		double c = 1;
		String result = "Equilateral";
		String triangleType = service.getTriangleType(a, b, c);
		assertEquals(result, triangleType);
	}
	@Test
	public void triangle_test_Isoscles() {
		double a = 1;
		double b = 1;
		double c = 2;
		String result = "Isoscles";
		String triangleType = service.getTriangleType(a, b, c);
		assertEquals(result, triangleType);
	}
	@Test
	public void triangle_test_Scalene() {
		double a = 1;
		double b = 7;
		double c = 2;
		String result = "Scalene";
		String triangleType = service.getTriangleType(a, b, c);
		assertEquals(result, triangleType);
	}
}
