package com.bcits.datastructure;

import java.util.Arrays;
import java.util.Scanner;

public class Question5 {

	static Scanner sd = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter the number of players : ");
		int num = Integer.parseInt(sd.nextLine());
		Player[] array = new Player[num];
		for (int i = 1; i <= num; i++) {
			System.out.println("Enter the " + i + " Player Name and score ");
			array[i - 1] = new Player(sd.nextLine(), Integer.parseInt(sd.nextLine()));
		}
		/*
		 * Player[] array = new Player[5]; array[0] = new Player("amy", 150); array[1] =
		 * new Player("david", 100); array[2] = new Player("heraldo", 50); array[3] =
		 * new Player("aleksa", 150); array[4] = new Player("aakansha", 100);
		 */
		Arrays.sort(array, new SortPlayer());
		for (Object ob : array) {
			System.out.println(ob);
		}
		sd.close();
	}

}
