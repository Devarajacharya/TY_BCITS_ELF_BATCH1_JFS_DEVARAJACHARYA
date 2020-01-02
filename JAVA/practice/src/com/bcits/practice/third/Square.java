/*WAP to calculate square of the given number using lambda expression*/
package com.bcits.practice.third;

interface SquareNum {
	public int square(int num);
}

public class Square {
	public static void main(String[] args) {
		SquareNum s1 = (num) -> {
			return num*num;
		};
		System.out.println("Square of the number is : "+s1.square(4));
	}
}