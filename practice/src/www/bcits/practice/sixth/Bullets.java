package www.bcits.practice.sixth;

import java.util.Scanner;

public class Bullets {

	private static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);
		System.out.println("Number of bullets load to the gun :");
		Gun g = new Gun(s.nextInt());
		System.out.println(g);
	}

}
