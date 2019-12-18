package com.bcits.practice.pattern;

public class Pattern7 {
	
	public static void main(String[] args) {
		int [][] num= {{0,0,0,0,1},
				 	   {0,0,1,0,1},
				 	   {0,1,0,0,1},
				 	   {1,0,0,0,1},
				 	   {0,1,0,0,1},
				 	   {0,0,1,0,1},
				 	   {0,0,0,0,1}};
		for (int i = 0; i <7; i++) {
			for (int j = 0; j < 5; j++) {
				if (num[i][j]==1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}		
			}
			System.out.println();	
		}
	}
}


