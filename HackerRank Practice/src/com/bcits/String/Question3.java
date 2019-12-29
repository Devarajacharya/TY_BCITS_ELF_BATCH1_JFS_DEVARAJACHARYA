package com.bcits.String;

import java.util.Arrays;
import java.util.Scanner;

public class Question3 {

	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		char[] ch1 = str1.toCharArray();
		Arrays.sort(ch1);
		char[] ch2 = str2.toCharArray();
		Arrays.sort(ch2);
		String s1 = new String(ch1);
		String s2 = String.copyValueOf(ch2);
		if (s1.equalsIgnoreCase(s2)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sd = new Scanner(System.in);
		System.out.println("Enter the String 1 : ");
		String str1 = sd.next();
		System.out.println("Enter the String 2 : ");
		String str2 = sd.next();
		boolean res = isAnagram(str1, str2);
		if (res) {
			System.out.println("Anagram");
		} else {
			System.out.println("Not Anagram");
		}
		sd.close();
	}
}
