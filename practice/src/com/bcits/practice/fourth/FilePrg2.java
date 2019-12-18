/*WAP to read the data from file1 and write into the file2*/
package com.bcits.practice.fourth;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FilePrg2 {
	
	private static FileWriter fw1;
	private static FileReader fr1;
	private static Scanner sd;
	private static FileWriter fr;
	
	public static void main(String[] args)  {
		
		String path1="D:\\BCITS\\doc\\file1.txt";
		String path2="D:\\BCITS\\doc\\file2.txt";
		File f1 = new File(path1);
		File f2 = new File(path2);
		
		try {
			sd = new Scanner (System.in);
			System.out.println("Enter text to write int the file : ");
			fr = new FileWriter(f1);
			fr.write(sd.nextLine());
			fr.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			fr1 = new FileReader(f1);
			fw1 = new FileWriter(f2,true);	
		
			int len=(int)f1.length();
			char [] ch=new char[len];
			fr1.read(ch);
		
			fw1.write(ch);
			fw1.flush();
			System.out.println("File writting is completed..");
		}
		catch(IOException e){
			System.out.println("File is not found....");
		}
		}
}

