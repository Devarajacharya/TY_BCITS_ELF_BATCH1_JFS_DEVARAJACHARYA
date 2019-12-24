package com.bcits.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question3 {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the number of entries...");
		int num = Integer.parseInt(scanner.nextLine());
		Map<String, Long> map = new HashMap<String, Long>();
		for (int i = 1; i <= num; i++) {
			System.out.print(i + " )Enter the name : " + "\n");
			String name = scanner.nextLine();
			System.out.println("Enter the phone number");
			long n = Integer.parseInt(scanner.nextLine());
			map.put(name, n);
		}
		System.out.println(map.toString());
		System.out.print("Enter the name to search : ");
		String str = scanner.nextLine();
		
		if(map.get(str) != null) {
		System.out.print(str + " = " + map.get(str));
		} else {
			System.err.println("Not found");
		}

		scanner.close();
	}

}
