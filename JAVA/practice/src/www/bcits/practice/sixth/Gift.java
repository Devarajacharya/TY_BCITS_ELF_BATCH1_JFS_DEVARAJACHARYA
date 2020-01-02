package www.bcits.practice.sixth;

import java.util.Scanner;

public class Gift {
	
	private static Scanner s;
	public static void main(String[] args) {
		s = new Scanner(System.in);
		System.out.println("Enter a gift  : ");
		Friend f =new Friend(s.nextLine());
		System.out.println(f);
	}
	
	
	

}
