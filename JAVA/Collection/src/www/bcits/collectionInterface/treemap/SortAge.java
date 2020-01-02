package www.bcits.collectionInterface.treemap;

import java.util.Comparator;

import www.bcits.collectionInterface.set.Person;

	public class SortAge implements Comparator <Person>{

		@Override
		public int compare(Person o1, Person o2) {
			return o1.age - o2.age;
		}

}
