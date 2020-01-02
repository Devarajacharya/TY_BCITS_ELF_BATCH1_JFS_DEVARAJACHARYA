package com.bcits.practice.second;

import java.util.Scanner;

public class String4 {
	
	private static Scanner sd;
	public static String revString(String str) {
    	String[] word = str.split(" ");
    	String res="";
    	for (int i = 0; i < word.length; i++) {
			if(i == 0) {
				res+=word[word.length-1]+" ";
			} else if (i % 2 == 0){
				res+=word[i-2]+" ";
			} else {
				res+=word[i]+" ";
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


