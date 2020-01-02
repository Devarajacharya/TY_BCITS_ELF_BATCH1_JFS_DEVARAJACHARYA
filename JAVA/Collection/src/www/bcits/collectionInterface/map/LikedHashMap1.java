package www.bcits.collectionInterface.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class LikedHashMap1 {
	public static void main(String[] args) {
		LinkedHashMap<String, Long> m1 = new LinkedHashMap<String, Long>();
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
