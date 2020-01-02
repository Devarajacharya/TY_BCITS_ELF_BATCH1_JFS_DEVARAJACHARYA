package www.bcits.collectionInterface.treemap;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 {
	public static void main(String[] args) {
		TreeMap<String , Long> m1 =  new TreeMap<String, Long>();
		m1.put("Divya", 9563214578l);
		m1.put("Anu", 8526214578l);
		m1.put("Raju", 7854214578l);
		m1.put("Jhon", 9000214578l);
		Set<String> s2 = m1.keySet();
		Iterator<String> i2 = m1.keySet().iterator();
		for (String string : s2) {
			System.out.println(string + "   = " + m1.get(string));
		}

	}

}
