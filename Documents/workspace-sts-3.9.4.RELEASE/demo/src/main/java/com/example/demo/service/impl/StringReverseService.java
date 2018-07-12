package com.example.demo.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.service.MainService;

@Service
public class StringReverseService implements MainService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public String reverse(String str) {
		StringBuffer a = new StringBuffer(str);
		log.info("Request Data " + str);		
		return a.reverse().toString();
	}

	@Override
	public String getStringReverse(String str) {
		String words[] = str.split(" ");
		StringBuffer reversedString = new StringBuffer();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String reverseWord = "";
			for (int j = word.length() - 1; j >= 0; j--) {
				reverseWord = reverseWord + word.charAt(j);
			}
			reversedString.append(reverseWord + " ");
		}
		return reversedString.toString();
	}

	@Override
	public Long getFibSeries(long n) {
		long n1 = 0, n2 = 1, n3 = 0;
		for (int i = 2; i <= n; i++) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n3;
	}

	@Override
	public String getTriangleType(double a, double b, double c) {
		String result = "";
		if (a == b && b == c) {
			result = "Equilateral";
		} else if ((a == b & b != c) || (b == c & c != a)) {
			result = "Isoscles";
		} else if (a != b && b != c) {
			result = "Scalene";
		}
		return result;
	}
	@Override
	public Set<Integer> getSingleArray(Collection<Integer[]> collection) {
		Set<Integer> set = new HashSet<Integer>();
		for (Integer[] intArray : collection) {
			set.addAll(Arrays.asList(intArray));
		
	}
		return set;
}
}
