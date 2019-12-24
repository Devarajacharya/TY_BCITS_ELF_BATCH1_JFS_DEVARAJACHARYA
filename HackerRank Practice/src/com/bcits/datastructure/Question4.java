package com.bcits.datastructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Question4 {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter the Number of pairs ..");
		int num = Integer.parseInt(scanner.nextLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashSet<String> set = new HashSet<String>();
		for (int i = 1; i <= num; i++) {
			System.out.println("Enter the pair " + i);
			set.add(scanner.nextLine());

			list.add(set.size());
		}
		System.out.println("\n" + "All the unique Pairs ");
		for (int pair : list) {
			System.out.println(pair);
		}
		scanner.close();

	}

}
