package www.bcits.collectionInterface.treemap;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap2 {
	public static void main(String[] args) {
		TreeMap<Person , Integer> m1 =  new TreeMap<Person , Integer>();
		m1.put(new Person(24,"Raju"),47);
		m1.put(new Person(16,"Anu"),23);
		m1.put(new Person(44,"Manu"),56);
		
		Set<Person> s2 = m1.keySet();
		Iterator<Person> i2 = m1.keySet().iterator();
		for (Person person : s2) {
			System.out.println(person);
		}

	}

}
