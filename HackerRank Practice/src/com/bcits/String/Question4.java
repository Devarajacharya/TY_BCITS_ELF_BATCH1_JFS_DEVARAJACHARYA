package com.bcits.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Question4 {

	public static String primeNum(HashSet<Integer> arr) {
		String n1 = "";
		for (Integer num : arr) {
			int count = 0;
			for (int j = 1; j <= num; j++) {
				if (num % j == 0) {
					count++;
				}
			}
			if (count == 2) {
				n1 += num + " ";
			}
		}
		return n1;

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashSet<Integer> arr = new HashSet<Integer>();
		System.out.println("Enter the number of Query : ");
		int num = Integer.parseInt(scan.nextLine());
		System.out.println("Enter the Integer");
		ArrayList<String> a1 = new ArrayList<String>();
		for (int i = 1; i <= num; i++) {
			int n = scan.nextInt();
			arr.add(n);
			String res = primeNum(arr);
			if(res != "") {
				a1.add(res);
			}
		}
		System.out.println("The Result is : ");
		for (String res : a1) {
			System.out.println(res);
		}
		scan.close();
	}

}
