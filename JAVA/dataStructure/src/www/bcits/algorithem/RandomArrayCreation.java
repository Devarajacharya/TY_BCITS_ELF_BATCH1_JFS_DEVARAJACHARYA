package www.bcits.algorithem;

import java.util.Random;
import java.util.Scanner;

public class RandomArrayCreation {
	
	private static Scanner sd;
	static int size;

	public static int [] arrValue() {
		System.out.print("Enter the Size of the array : ");
		sd = new Scanner(System.in);
		size = sd.nextInt();
		Random rd = new Random ();
		int[] arr = new int[size];
	      for (int i = 0; i < arr.length; i++) {
	         arr[i] = rd.nextInt(20);
	      }
		return arr;
	  }
}
