package com.bcits.practice.pattern;

public class Pattern9 {
	
	public static void main(String[] args) {
		int n=7;
		for (int i = 0; i < n; i++) {
			if(i == n/2) {
				for (int j = 0; j < n; j++) {
					System.out.print(" *");
				}
				System.out.println();
			} else {
					for (int j = 0; j <= n; j++) {
						if(j == 7) {
						System.out.println("*");
						} else {
							System.out.print(" ");
						}
					}	
			}
		}
	
	}
}
