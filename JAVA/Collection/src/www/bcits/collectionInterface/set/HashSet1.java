package www.bcits.collectionInterface.set;

import java.util.HashSet;

public class HashSet1 {
	public static void main(String[] args) {
		HashSet<Integer> h1 = new HashSet<Integer>();
		h1.add(10);
		h1.add(36);
		h1.add(35);
		h1.add(28);
		System.out.println(h1);
		h1.remove(35);
		System.out.println(h1);
		h1.add(null);
		System.out.println(h1);
		h1.add(10);
		System.out.println(h1);
	}

}
