package com.bcits.practice.pattern;

public class Pattern11 {
	
	public static void main(String[] args) {
		int[][]arr = {{1,1,1,1,1,1,1,1,1},
					  {1,1,0,0,1,0,0,1,1},
					  {1,0,1,0,1,0,1,0,1},
					  {1,0,0,1,1,1,0,0,1},
					  {1,1,1,1,1,1,1,1,1},
					  {1,0,0,1,1,1,0,0,1},
					  {1,0,1,0,1,0,1,0,1},
					  {1,1,0,0,1,0,0,1,1},
					  {1,1,1,1,1,1,1,1,1}};
					  
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(arr[i][j] == 1) {
					System.out.print(" *");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

}
