package www.bcits.collectionInterface.List;

import java.util.Vector;

public class Vector2 {
	public static void main(String[] args) {
		Vector<Integer> v1 = new Vector<Integer>();
		v1.insertElementAt(34, 0);
		v1.insertElementAt(67, 1);
		v1.insertElementAt(24, 2);
		v1.insertElementAt(47, 3);
		System.out.println(v1);
		v1.removeElement(new Integer(47));
		System.out.println(v1);
		System.out.println(v1.capacity());
		System.out.println(v1.size());
		v1.trimToSize();
		System.out.println(v1.capacity());
		System.out.println(v1.size());
		v1.ensureCapacity(4);
		System.out.println("-----------ensureCapacity---------");
		System.out.println(v1.capacity());
		
	}

}
