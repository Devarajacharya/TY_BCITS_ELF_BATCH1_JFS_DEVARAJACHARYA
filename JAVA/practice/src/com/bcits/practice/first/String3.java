package com.bcits.practice.first;

import java.util.Scanner;

public class String3 {
	
	private static Scanner sd;
	public static String revString(String str) {
		String res="";
    	String[] word = str.split(" ");
    	for (int i = 0; i < word.length; i++) {
    		String s=word[i];
    		String rev="";
    		if(i % 2 == 0) {
    			for (int j = s.length()-1; j >= 0; j--) {
    				rev+=s.charAt(j);
    			}
    			res+=rev+" ";
    		} else {
    			res+=s+" ";
    		}	
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		sd = new Scanner(System.in);
		System.out.println("Enter the String here : ");
		String str=sd.nextLine();
		System.out.println("Result is : "+revString(str));
	}
}
