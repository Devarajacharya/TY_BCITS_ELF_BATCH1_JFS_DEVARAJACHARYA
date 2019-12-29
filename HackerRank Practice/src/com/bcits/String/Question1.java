package com.bcits.String;

import java.util.Scanner;

public class Question1 {
	//First Method
	public static boolean palindrome1(String str) {
		char[] ch = str.toCharArray();
		int mid = str.length() / 2;
		int len = str.length() - 1;
		for (int i = 0; i < mid; i++) {
			if (ch[i] != ch[len - i]) {
				return false;
			}
		}
		return true;
	}
	//Second Method
	public static boolean palindrome2(String str) {
		int mid = str.length() / 2;
		int len = str.length() - 1;
		for (int i = 0; i < mid; i++) {
			if (str.charAt(i) == str.charAt(len - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sd = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = sd.next();
		Boolean res2 = CountDuration.CountDurationPalindrome1(str);
		Boolean res1 = CountDuration.CountDurationPalindrome2(str);

		if (res1 || res2) {
			System.out.println("Given String is Palindrome.");
		} else {
			System.out.println("Given string is not a Palindrome");
		}
		sd.close();
	}

}
