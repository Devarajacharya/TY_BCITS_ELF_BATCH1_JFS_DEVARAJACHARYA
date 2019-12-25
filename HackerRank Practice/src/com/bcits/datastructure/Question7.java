package com.bcits.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Question7 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int n = in.nextInt();
		int m = in.nextInt();
		int maxUnique = 0;
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			if (i == 0) {
				deque.add(num);
				maxUnique++;
			} else {
				if (deque.size() == m) {
					deque.removeFirst();
				}
				if (!deque.contains(num) && maxUnique < m) {
					maxUnique++;
				}
				deque.addLast(num);
			}
		}
		System.out.println(maxUnique);
	}
}
