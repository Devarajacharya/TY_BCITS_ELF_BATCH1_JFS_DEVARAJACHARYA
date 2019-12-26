package www.bcits.collectionInterface.queue;

import java.util.PriorityQueue;

public class PriorityQueue1 {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> p1 = new PriorityQueue <Integer>();
		p1.add(10);
		p1.add(20);
		p1.add(30);
		p1.add(40);
		p1.add(10);
		System.out.println(p1);
		p1.remove();
		System.out.println(p1);
		p1.remove();
		System.out.println(p1);
		System.out.println(p1.size());

	}

}
