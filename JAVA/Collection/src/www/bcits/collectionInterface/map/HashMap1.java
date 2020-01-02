package www.bcits.collectionInterface.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap1 {
	public static void main(String[] args) {
		HashMap<String, Long> m1 = new HashMap<String, Long>();
		m1.put("Divya", 9563214578l);
		m1.put("Anu", 8526214578l);
		m1.put("Raju", 7854214578l);
		m1.put("Jhon", 9000214578l);
		
//		Set<Map.Entry<String,Long>> s1 = m1.entrySet();
//		for (Map.Entry<String, Long> entry : s1) {
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//			System.out.println("----------");
//			
//		}

		Set<String> s2 = m1.keySet();
		Iterator<String> i2 = m1.keySet().iterator();
		for (String string : s2) {
			System.out.println(string + "   = " + m1.get(string));
		}

	}

}
