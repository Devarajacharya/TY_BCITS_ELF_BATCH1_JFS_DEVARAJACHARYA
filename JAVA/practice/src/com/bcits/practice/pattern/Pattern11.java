package com.bcits.practice.pattern;

public class Pattern11 {
		
		public static void main(String[] args) {
			int n=5;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 11; j++) {
					if (i == 5) {
						System.out.print("*");
					} else if ((j == n-i) || (j == n+i) || (j == n)) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
				} 
			for (int i = 4; i >= 0; i--) {
				for (int j = 0; j < 11; j++) {
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
