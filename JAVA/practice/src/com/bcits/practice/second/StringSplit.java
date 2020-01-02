package com.bcits.practice.second;

import java.util.Scanner;

public class StringSplit {
	
	private static Scanner sd;
	public static String split(String str) {
	String res="";
	String[] word = str.split(" ");
	for (int i = 0; i < word.length; i++) {
		res=res+word[i]+word[i].length()+" ";
	}
	return res;
	
}

public static void main(String[] args) {
	sd = new Scanner(System.in);
	System.out.println("Enter the String here : ");
	String str=sd.nextLine();
	System.out.println("Result is : "+split(str));
}
}
