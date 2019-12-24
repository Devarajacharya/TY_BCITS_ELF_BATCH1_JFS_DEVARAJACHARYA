package com.bcits.practice.exception;

import java.io.File;
import java.io.IOException;

public class Cust_Exception {
	
	public static void main(String[] args) {
	File f1 = new File("D:\\BCITS\\doc\\file4.txt");
	
	try {
		f1.createNewFile();
		System.out.println("File created..");
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}

	
