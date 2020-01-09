package com.bcits.datastructure;

import java.util.Scanner;

public class Question7 {

	public static void printArray(Object[] arr) {
		for (Object object : arr) {
			System.out.println(object);
		}
	}

	public static void main(String[] args) {
		Scanner sd = new Scanner(System.in);

		System.out.println("Enter the Array Size : ");
		int size = Integer.parseInt(sd.nextLine());
		Integer[] intarr = new Integer[size];
		String[] strarr = new String[size];
		System.out.println("Enter the all the Integer Array Elements : ");
		for (int i = 0; i < size; i++) {
			intarr[i] = Integer.parseInt(sd.nextLine());
		}
		System.out.println("Enter the all the String array Elements : ");
		for (int j = 0; j < size; j++) {
			strarr[j] = sd.nextLine();
		}

		System.out.println("The result is : ");
		printArray(intarr);
		printArray(strarr);

		sd.close();
	}
}
