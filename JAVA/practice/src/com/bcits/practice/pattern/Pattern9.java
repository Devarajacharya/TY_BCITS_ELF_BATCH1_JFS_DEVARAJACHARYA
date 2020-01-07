package com.bcits.practice.pattern;

public class Pattern9 {
	
	public static void main(String[] args) {
		int n=3;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				if((j == n-i) || (j == n+i)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
			} 
		for (int i = 2; i >= 0; i--) {
			for (int j = 0; j < 7; j++) {
				if((j == n-i) || (j == n+i)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
			} 
		
	}
}
