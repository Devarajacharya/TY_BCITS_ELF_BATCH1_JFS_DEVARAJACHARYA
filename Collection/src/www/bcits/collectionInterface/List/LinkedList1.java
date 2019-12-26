package www.bcits.collectionInterface.List;

import java.util.LinkedList;

public class LinkedList1 {
	
	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(23);
		l1.add(34);
		l1.add(60);
		System.out.println(l1);
		System.out.println("--------------" +"\n");
		l1.remove(0);
		System.out.println(l1);
		System.out.println("--------------" +"\n");
		l1.add(2, 87);
		System.out.println(l1);
		System.out.println("--------------" +"\n");
		System.out.println(l1.isEmpty());
		System.out.println("--------------" +"\n");

		System.out.println(l1);
		System.out.println("--------------" +"\n");
		System.out.println(l1.size());
		System.out.println("--------------" +"\n");

		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.add(60);
		l2.add(34);
		System.out.println(l2);
		System.out.println("--------------" +"\n");
		System.out.println(l1.contains(l2));
		System.out.println("--------------" +"\n");
		
		
		
	}

}
