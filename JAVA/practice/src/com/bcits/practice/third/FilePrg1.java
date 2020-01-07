/*WAP to read the data from file1 and write into the file2*/
package com.bcits.practice.third;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrg1 {
	
	private static FileWriter fw1;
	private static FileReader fr1;
	
	public static void main(String[] args)  {
		String path1="D:\\Study material\\BCITS Practice\\dfile\\file1.txt";
		String path2="D:\\Study material\\BCITS Practice\\dfile\\file2.txt";
		File f1 = new File(path1);
		File f2 = new File(path2);
		try {
			fr1 = new FileReader(f1);
			fw1 = new FileWriter(f2);	
		
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



