package com.bcits.practice.fourth;

import java.util.ArrayList;
import java.util.Collections;

public class MobileInfo {
	
	public static void main(String[] args) {
		ArrayList<Mobile> a1 = new ArrayList<>();
		a1.add(new Mobile("OnePluse 7",29995));
		a1.add(new Mobile("Mi note 7",16000));
		a1.add(new Mobile("iphone 11",110099));
		a1.add(new Mobile("Samsung Note 10",69800));
		
		Collections.sort(a1);
		for (Mobile obj : a1) {
			System.out.println(obj);
		}


}
}
