package com.bcits.datastructure;

import java.util.Comparator;

public class SortStudent implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getCgpa() < o2.getCgpa()) {
			return 1;
		} else if (o1.getCgpa() > o2.getCgpa()) {
			return -1;
		} else if (o1.getName() != o2.getName()) {
			return o1.getName().compareTo(o2.getName());
		} else
			return o1.getId() - o2.getId();
	}

}
