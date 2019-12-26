package www.bcits.collectionInterface.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList1 {

	public static void main(String[] args) {

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(36);
		a1.add(87);
		System.out.println("---------For Loop---------");
		for (int i = 0; i < a1.size(); i++) {
			System.out.println(a1.get(i));
		}
		System.out.println("-------ForEach Loop----------");
		for (Integer integer : a1) {
			System.out.println(integer);
		}
		System.out.println("-------Iterator------------");
		Iterator<Integer> i1 = a1.iterator();
		while (i1.hasNext()) {
			System.out.println(i1.next());
			a1.add(100);
		}
		System.out.println("--------listIterator in forword direction---------");
		ListIterator<Integer> l1 = a1.listIterator();
		while (l1.hasNext()) {
			System.out.println(l1.next());
		}
		System.out.println("--------listIterator in Reverse direction---------");
		ListIterator<Integer> l2 = a1.listIterator(a1.size());
		while (l2.hasPrevious()) {
			System.out.println(l2.previous());
		}
	}

}
