package com.bcits.datastructure;

import java.util.ArrayList;
import java.util.Collections;

public class Question6 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(33, "Rumpa", 3.68));
		list.add(new Student(85, "Ashis", 3.85));
		list.add(new Student(56, "Samiha", 3.75));
		list.add(new Student(19, "Samiha", 3.75));
		list.add(new Student(22, "Fahim", 3.76));

		Collections.sort(list, new SortStudent());
		for (Object ob : list) {
			System.out.println(ob);
		}

	}
}
