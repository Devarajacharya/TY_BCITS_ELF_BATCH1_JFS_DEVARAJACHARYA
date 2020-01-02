package www.bcits.exceptionhandling.coustomunchecked;

import java.util.Scanner;

public class TestA {
	public static void main(String[] args) {
		Scanner sd = new Scanner(System.in);
		System.out.println("Enter the Age : ");
		Election e1 = new Election();
		try {
			e1.vote(sd.nextInt());
		} catch (AgeLimitException e) {
			System.out.println(e.getMsg());
		}
		
	}

}
