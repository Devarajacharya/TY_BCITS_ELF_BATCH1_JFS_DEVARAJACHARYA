package com.bcits.String;

import java.util.Scanner;

public class Question1 {
	public static boolean palindrome(String str) {
		char[] ch =str.toCharArray();
		int mid = str.length()/2;
		int len = str.length()-1;
		for (int i = 0; i < mid; i++) {
			if(ch[i] != ch[len-i]) {
				return false;
			}
		}
		return true;
		
	}
	public static void main(String[] args) {
		Scanner sd = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = sd.next();
		if(palindrome(str)) {
			System.out.println("Given String is Palindrome.");
		} else {
			System.out.println("Given string is not a Palindrome");
		}
		sd.close();
	}
	

}
