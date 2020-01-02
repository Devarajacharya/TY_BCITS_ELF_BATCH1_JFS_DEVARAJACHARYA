package com.bcits.practice.second;

import java.util.Scanner;

public class StringRev {
	
	private static Scanner sd;

	public static String rev(String str) {
		String res="";
		for (int i = str.length()-1; i >=0 ; i--) {
			res+=str.charAt(i);	
		}
		return res;
	}
	
	public static void main(String[] args) {
		sd = new Scanner(System.in);
		System.out.println("Enter the String here : ");
		String str=sd.nextLine();
		System.out.println("Reversed String is : "+rev(str));
	}
}
