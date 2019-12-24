package com.bcits.practice.exception;

import java.util.Scanner;

public class UncheckedExp  {
	
	private static Scanner sd;
	public static void check(int num)  {
		int [] arr = {1,2,3,4};
		int res=5/num;
		System.out.println(res);
		System.out.println(arr[num]);
	}

	public static void main(String[] args) throws Exception {
		sd = new Scanner(System.in);
		System.out.println("Enter the number here : ");
		int num=sd.nextInt();
		check(num);
	}
}

