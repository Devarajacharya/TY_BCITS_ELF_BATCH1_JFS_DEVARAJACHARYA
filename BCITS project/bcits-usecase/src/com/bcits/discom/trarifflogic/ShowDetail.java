package com.bcits.discom.trarifflogic;

import java.util.Iterator;
import java.util.Set;

public class ShowDetail {
	public static void showAllDetails() {
		System.out.println("-------------All Details--------------");
		Set keys =MainClass.map.keySet();
		Iterator il = keys.iterator();
		while (il.hasNext()) {
			System.out.println(MainClass.map.get(il.next()));
		}
	}

}
