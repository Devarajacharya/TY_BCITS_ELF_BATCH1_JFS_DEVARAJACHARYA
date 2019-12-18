package com.bcits.practice.employee;

import java.util.Comparator;

public class SortBySal implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Employee n1 = (Employee)o1;
		Employee n2 = (Employee)o2;
		return (int) (n1.sal-n2.sal);
	}

}
