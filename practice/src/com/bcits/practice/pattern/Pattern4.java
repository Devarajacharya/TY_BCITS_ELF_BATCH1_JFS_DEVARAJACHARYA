package com.bcits.practice.pattern;

public class Pattern4 {
	
	public static void main(String[] args) {
		for (int i = 0; i <= 4; i++) {
			for (int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
				System.out.println();
		}
	}
}
