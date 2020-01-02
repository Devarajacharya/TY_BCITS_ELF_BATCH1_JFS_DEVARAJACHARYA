package www.bcits.collectionInterface.collection;

import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {

	public static void main(String[] args) {
		Collection<Integer> c1 = new ArrayList<Integer>();
		c1.add(25);
		c1.add(75);
		c1.add(50);
		System.out.println(c1);
		c1.remove(75);
		System.out.println(c1);
		System.out.println(c1.isEmpty());
		System.out.println(c1.size());
		System.out.println(c1.contains(25));
		System.out.println(c1.containsAll(c1));
	}

}
