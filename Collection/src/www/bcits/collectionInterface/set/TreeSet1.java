package www.bcits.collectionInterface.set;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TreeSet1 {
	public static void main(String[] args) {
		TreeSet<Integer> t1 = new TreeSet<Integer>();
		t1.add(10);
		t1.add(36);
		t1.add(35);
		t1.add(28);
		System.out.println(t1);
		t1.remove(35);
		System.out.println(t1);
		t1.add(10);
		System.out.println(t1);
	}
	

}
