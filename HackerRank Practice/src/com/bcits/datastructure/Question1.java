package com.bcits.datastructure;

import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("Enter the number of lines...");
		int num = scanner.nextInt();
		ArrayList <ArrayList<Integer>> arr1 = new ArrayList <ArrayList<Integer>>(num);
		ArrayList<Integer> arr2 =null;
		
		for (int i = 1; i <= num; i++) {
			System.out.println("Enter the number of elements in " +i + "  array ");
			int d = scanner.nextInt();
			arr2 = new ArrayList<Integer> (d);
			arr2.add(d);
			for (int j = 1; j <= d ; j++) {
				System.out.println("Enter the number at index  " +j);
				arr2.add(scanner.nextInt());
			}
			System.out.println(arr2.toString());
			arr1.add(arr2);
		}
		System.out.println(arr1.toString());
		
		System.out.println("Number of elemts to search  ..");
		int n =scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.print("Enter the line number : " +"\n");
			int x = scanner.nextInt();
			
			System.out.print("Enter the position of the  element : " +"\n");
			int y = scanner.nextInt();
			
				try {
					System.out.println(arr1.get(x-1).get(y));
				} catch(Exception e) {
					System.err.println("Invalid entry..");
				}
		}
		scanner.close();
		
	}
}
