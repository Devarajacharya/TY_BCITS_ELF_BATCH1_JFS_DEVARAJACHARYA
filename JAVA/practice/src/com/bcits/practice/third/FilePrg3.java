/*WAP to read the data from file1 and write into the file2*/
package com.bcits.practice.third;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrg3 {
	
	private static FileWriter fw1;
	private static FileReader fr1;
	private static FileReader fr2;
	public static void main(String[] args)  {
		
		String path1="D:\\Study material\\BCITS Practice\\dfile\\file1.txt";
		String path2="D:\\Study material\\BCITS Practice\\dfile\\file2.txt";
		String path3="D:\\Study material\\BCITS Practice\\dfile\\file3.txt";
		File f1 = new File(path1);
		File f2 = new File(path2);
		File f3 = new File(path3);
		
		try {
			fr1 = new FileReader(f1);
			fr2 = new FileReader(f2);
			fw1 = new FileWriter(f3,true);	
		
			int len1=(int)f1.length();
			char [] ch1=new char[len1];
			fr1.read(ch1);
			
			int len2=(int)f2.length();
			char [] ch2=new char[len2];
			fr2.read(ch2);
		
			fw1.write(ch1);
			fw1.write(ch2);
			fw1.flush();
			
			System.out.println("File writting is completed..");
		}
		catch(IOException e){
			System.out.println("File is not found....");
		}
		}
}
