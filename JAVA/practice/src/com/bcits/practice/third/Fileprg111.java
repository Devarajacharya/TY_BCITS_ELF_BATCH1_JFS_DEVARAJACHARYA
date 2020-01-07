package com.bcits.practice.third;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * WAP to read the data from file1 and write into the file2
*/

public class Fileprg111 {
	
	private static FileOutputStream fw1;
	private static FileInputStream fr1;
	public static void main(String[] args)  {
		
		String path1="D:\\Study material\\BCITS Practice\\dfile\\file1.txt";
		String path2="D:\\Study material\\BCITS Practice\\dfile\\file2.txt";
		File f1 = new File(path1);
		File f2 = new File(path2);
		
		try {
			fr1 = new FileInputStream(f1);
			fw1 = new FileOutputStream(f2); 	
			int byteValue;
			while ((byteValue = fr1.read()) != -1) {
				fw1.write(byteValue);
			}
			System.out.println("File writting is completed..");
		}
		catch(IOException e){
			System.out.println("File is not found....");
		}
		}
}
