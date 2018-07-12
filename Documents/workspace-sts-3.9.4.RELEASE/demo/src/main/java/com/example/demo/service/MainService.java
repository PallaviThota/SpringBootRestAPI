package com.example.demo.service;

import java.util.Collection;
import java.util.Set;



public interface MainService {
	
	public Long getFibSeries(long n);
	
	public String reverse(String str);
	
	public String getStringReverse(String str);
	public String getTriangleType(double a, double b, double c);
	public Set<Integer> getSingleArray(Collection<Integer[]> collection);
	
}
