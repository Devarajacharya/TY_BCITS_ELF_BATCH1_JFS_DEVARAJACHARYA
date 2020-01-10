package com.bcits.LambdaExpression;

import java.util.Scanner;

interface EvenOrOdd {
	public void evenOdd(int num);
}

interface Prime {
	public void primeNum(int num1);
}

interface Plaindrome {
	public void stringPalindrome(String str);
}


public class LambdaExpression {
	
	public static void main(String[] args) {
		EvenOrOdd e1 = (a)-> {
			if(a % 2 == 0) {
				System.out.println("EVEN");
			} else {
				System.out.println("ODD");
			}
		};
		
		Prime p1 = (num)-> {
			int count = 0;
			for (int i = 1; i <= num; i++) {
				if(num % i == 0) {
					count++;
				}
			}
			if(count == 2) {
				System.out.println("PRIME");
			} else {
				System.out.println("COMPOSITE");
			}
		};
		
		Plaindrome palin = (str)-> {
			int len =str.length()-1;
			int mid = str.length()-1;
			int count = 0;
			for (int i = 0; i <mid; i++) {
				if(str.charAt(i) != str.charAt(len-i)) {
					System.out.println("NOT A PALINDROME");
					break;
				} else {
					count++;
					if(count == mid) {
						System.out.println("PALINDROME");
					}
				}
			}
			
		};
		
		
		Scanner sd = new Scanner(System.in);
		System.out.println("Enter the Number Of Query  : ");
		int num = Integer.parseInt(sd.nextLine());
		System.out.println("Enter the Condition to Check"+ "\n" +"1.Even/Odd   2.Prime   3.Plindrome");
		for (int i = 0; i <num; i++) {
			switch (Integer.parseInt(sd.nextLine())) {
			case 1: e1.evenOdd(Integer.parseInt(sd.nextLine()));
					break;
					
			case 2: p1.primeNum(Integer.parseInt(sd.nextLine()));
					break;
					
			case 3: palin.stringPalindrome(sd.nextLine());
			        break;

			default: System.out.println("Invalid Entry...");
				break;
			}
		}
		sd.close();
	}

}
