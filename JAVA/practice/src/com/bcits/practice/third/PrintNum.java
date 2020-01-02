package com.bcits.practice.third;
/*
 * WAP to print the number of given range using lambda function
 **/

interface NumRange {
	public void range(int start,int end);
}

public class PrintNum {
	public static void main(String[] args) {
		NumRange r1 = (a,b) -> {
			for (int i = a; i <= b; i++) {
				System.out.println("n = "+i);
			}
		};
		r1.range(1, 10);
	}

}
