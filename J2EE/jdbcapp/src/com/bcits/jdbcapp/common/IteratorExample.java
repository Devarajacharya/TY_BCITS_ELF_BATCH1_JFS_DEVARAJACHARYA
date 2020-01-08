package com.bcits.jdbcapp.common;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {

	public static void main(String[] args) {
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("one");
		a1.add("two");
		a1.add("three");
		a1.add("four");
		a1.add("five");

		Iterator<String> i1 = a1.iterator();
		while (i1.hasNext()) {
			System.out.println(i1.next());
		}

	}
}
