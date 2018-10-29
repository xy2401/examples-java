package com.xy2401.example.demo.lambda;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {
	public int compare(String arg0, String arg1) {
		return arg0.compareToIgnoreCase(arg1);
	}

}