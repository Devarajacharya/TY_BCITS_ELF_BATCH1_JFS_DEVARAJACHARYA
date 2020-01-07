package www.bcits.practice.exception;

import java.io.File;
import java.io.IOException;

public class CheckedExp {
	
	public static void main(String[] args) {
		File f1 = new File("D:\\Study material\\BCITS Practice\\dfile\\file6.txt");
		try {
			f1.createNewFile();
			System.out.println("file is created...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
