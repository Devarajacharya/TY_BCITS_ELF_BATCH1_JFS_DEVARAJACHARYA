package com.bcits.practice.pattern;

public class Pattern6 {
	
	static int n=1;
	public static void main(String[] args) {
		for (int i = n; i <= 7; i=i+2) {
			for (int j = i; j < 7; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}	
	}
}
