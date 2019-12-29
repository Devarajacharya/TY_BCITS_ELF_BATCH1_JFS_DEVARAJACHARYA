package com.bcits.String;

import java.util.Scanner;

public class Question2 {
	
	public static String getSmallestAndLargest(String s, int k) {
        String small = "";
        String large = "";
        for (int i = 0; i <= s.length()-k; i++) {
        	String substr =s.substring(i,i+k);
        	if(i == 0) {
        		small =substr;
        	}
			if(substr.compareTo(large) > 0) {
				large =substr;
			} else if (substr.compareTo(small) < 0) {
				small=substr;
			}
		}
        
		return small +"\n"+large;
	}
	
	public static void main(String[] args) {
		Scanner sd = new Scanner(System.in);
		System.out.println("Enter the String here : ");
		String str = sd.next();
		System.out.println("Entere the Integer value : ");
		int k = sd.nextInt();
		System.out.println(getSmallestAndLargest(str, k));
		sd.close();
		
	}
}
