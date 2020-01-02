package com.bcits.practice.pattern;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(12);
		a1.add(34);
		a1.add(33);
		a1.add(65);
		a1.add(34);
		System.out.println(a1);
//		List<Integer> i1 =a1.stream().map(i -> i*2).collect(Collectors.toList());
		List<Integer> i1 =a1.stream().filter(i ->i%2 ==0).collect(Collectors.toList());
		System.out.println(i1);
	}
}




