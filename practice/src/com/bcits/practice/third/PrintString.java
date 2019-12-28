
package com.bcits.practice.third;

/*
 * WAP to print a message using Lambda Function
 */

public class PrintString {

	public static Runnable getString() {
		return () -> {
			System.out.println("Hello world");
		};
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(getString());
		t1.start();
	}

}
