package www.bcits.collectionInterface.List;

import java.util.LinkedList;
import java.util.Vector;

public class Vector1 {

	public static void main(String[] args) {
		Vector<Integer> v1 = new Vector<Integer>();
		v1.ensureCapacity(5);

		v1.add(23);
		v1.add(null);
		v1.add(60);
		v1.add(23);
		System.out.println(v1);
		System.out.println("--------------" + "\n");
		v1.remove(1);
		System.out.println(v1);
		System.out.println("--------------" + "\n");
		System.out.println(v1.isEmpty());
		System.out.println("--------------" + "\n");

		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println("--------------" + "\n");

		Vector<Integer> v2 = new Vector<Integer>();
		v2.add(60);
		v2.add(34);
		System.out.println(v2);
		System.out.println("--------------" + "\n");
		System.out.println(v1.contains(v2));
		System.out.println("--------------" + "\n");
		
	
	}

}
