package www.bcits.collectionInterface.set;

import java.util.TreeSet;

public class TreeSet2 {
	public static void main(String[] args) {
		TreeSet<Person> t1 = new TreeSet<Person>(new SortAge());
		t1.add(new Person(12, "Sonu"));
		t1.add(new Person(42, "Deeksha"));
		t1.add(new Person(26, "Aishu"));
		t1.add(new Person(24, "Ramya"));
		
		for (Person person : t1) {
			System.out.println(person);
		}

		

	}

}
