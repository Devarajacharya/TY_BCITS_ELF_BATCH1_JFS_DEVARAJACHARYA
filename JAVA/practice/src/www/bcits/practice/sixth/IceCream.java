package www.bcits.practice.sixth;

import java.util.Scanner;

public class IceCream {
	private static Scanner sd;

	public static void main(String[] args) {
		sd = new Scanner(System.in);
		System.out.println("Enter the IceCream flavor : ");
		Baby b1= new Baby(sd.nextLine());
		System.out.println(b1);
	}
}
