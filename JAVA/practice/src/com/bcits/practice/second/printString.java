/*WAP to print a message using Lambda Function*/
package com.bcits.practice.second;
	
	interface print {
	public void printstr(String word);	
	}

	public class printString{
		public static void main(String[] args) {
			print s1 = (str) -> {
			System.out.println(str);
			};
		s1.printstr("Hello");
		}
	}
