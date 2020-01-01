package com.bcits.String;

import java.util.ArrayList;
import java.util.Scanner;

public class Question4 {

	public static ArrayList<String> duplicateWord(ArrayList<String> a1) {
		for (int i = 0; i < a1.size(); i++) {
			int index = 0;
			String[] str = (a1.get(i)).split(" ");
			String res = "";
			for (int j = 1; j < str.length; j++) {
				int k = 0;
				while (k < j) {
					if (str[j] == str[k]) {
						break;
					} else {
						k++;
					}
				}
				res += str[j] + " ";

				a1.set(i, res);
			}

		}
		return a1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> a1 = new ArrayList<String>();
		System.out.println("Enter the number of Query : ");
		int num = Integer.parseInt(scan.nextLine());
		for (int i = 1; i <= num; i++) {
			System.out.println("Enter the " + i + " String : ");
			a1.add(scan.nextLine());
		}
		ArrayList<String> l1 = duplicateWord(a1);
		for (Object object : l1) {
			System.out.println(object);
		}
		scan.close();
	}

}
