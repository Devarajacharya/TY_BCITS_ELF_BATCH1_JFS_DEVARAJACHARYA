package www.collectionInterface.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deque1 {
	
	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque <Integer>();
		dq.add(34);
		dq.add(73);
		dq.add(36);
		dq.add(45);
		for (Integer integer : dq) {
			System.out.println(integer);
		}
			
		
	}

}

