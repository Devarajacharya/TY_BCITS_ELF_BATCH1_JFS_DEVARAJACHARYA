package www.bcits.collectionInterface.collection;

import java.util.ArrayList;
import java.util.Collection;

public class Collection2 {

	public static void main(String[] args) {
		Collection<Integer> c1 = new ArrayList<Integer>();
		c1.add(20);
		c1.add(30);
		Collection<Integer> c2 = new ArrayList<Integer>();
		c2.add(10);
		c2.add(30);
		c2.add(40);
		System.out.println(c1);
		System.out.println(c2);
		c2.addAll(c1);
		System.out.println("------------------------------");
		System.out.println(c1);
		System.out.println(c2);
		c2.removeAll(c1);
		System.out.println("------------------------------");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println("\n" + "-----ContainAll and retainAll-----" + "\n");

		Collection<Integer> c3 = new ArrayList<Integer>();
		c3.add(50);
		c3.add(70);
		Collection<Integer> c4 = new ArrayList<Integer>();
		c4.add(80);
		c4.add(70);
		c4.add(90);

		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c4.containsAll(c3));
		System.out.println("----------------------------");
		c4.retainAll(c3);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println("-----------toArray----------");
		Object[] o1 = c4.toArray();
		for (int i = 0; i < o1.length; i++) {
			System.out.println(o1[i]);
		}

	}

}
