package www.bcits.collectionInterface.List;

import java.util.ArrayList;
import java.util.List;

public class ArrayList1 {

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(25);
		a1.add(45);
		a1.add(0, 77);
		System.out.println(a1);
		System.out.println("-------Remove--------");
		a1.remove(0);
		System.out.println(a1);
		System.out.println("--------set--------");
		a1.set(1, 77);
		System.out.println(a1);
		a1.add(25);
		System.out.println(a1);
		System.out.println("index of : " + a1.indexOf(25));
		System.out.println("Last index of : " + a1.lastIndexOf(25));
		System.out.println("--------------------");

		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(34);
		a2.add(45);
		System.out.println(a2);
		System.out.println("--------addAll--------");
		a1.addAll(1, a2);
		System.out.println(a1);
		System.out.println("--------SubList---------");

		List<Integer> a3 = a1.subList(0, 3);
		System.out.println(a3);

		for (int i = 0; i < a1.size(); i++) {
			System.out.print(a1.get(i) + "  ");

		}
	}

}
