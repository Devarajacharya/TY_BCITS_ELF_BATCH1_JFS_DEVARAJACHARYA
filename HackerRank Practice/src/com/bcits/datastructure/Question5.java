package com.bcits.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question5 {
		
	public static void main(String[] args) {
		ArrayList <Player> list = new ArrayList<Player> ();
		ArrayList<String> list2 = new ArrayList<String>();
		list.add(new Player("amy",100));
		list.add(new Player("david",100));	
		list.add(new Player("heraldo",50));
		list.add(new Player("aleksa",150));
		list.add(new Player("john",75));
		
		Collections.sort(list , new SortScore());
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i-1) == list.get(i) ) {
				
			}
		}
		
		
	}

}
