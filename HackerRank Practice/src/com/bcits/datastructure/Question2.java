package com.bcits.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2 {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the number of elements : ");
		int n = Integer.parseInt(scanner.nextLine());
		List<Integer> list = new ArrayList<Integer>(n);
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter the elements for index " + i);
			list.add(Integer.parseInt(scanner.nextLine()));
		}
		System.out.println(list.toString());
		System.out.println("Enter the number of query  :  " + "\n");
		int q = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < q; i++) {
			System.out.println("Enter the querry  1)Insert  2)Delete  ");
			String str = scanner.nextLine();
			if (str.equalsIgnoreCase("INSERT")) {
				System.out.print("Enter the index for insertion  : " + "\n");
				int x = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter the value for insertion  : " + "\n");
				int y = Integer.parseInt(scanner.nextLine());
				list.add(x, y);
			} else if (str.equalsIgnoreCase("DELETE")) {
				System.out.print("Enter the index for Delete  : " + "\n");
				int x = Integer.parseInt(scanner.nextLine());
				list.remove(x);
			} else {
				System.out.println("Enter valid Query..!!");
			}
			System.out.println(list);

		}

	}

}
