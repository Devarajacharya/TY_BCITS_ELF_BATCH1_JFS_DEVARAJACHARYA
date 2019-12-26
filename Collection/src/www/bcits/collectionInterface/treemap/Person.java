package www.bcits.collectionInterface.treemap;


public class Person implements Comparable<Person> {
	
	int age;
	String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
//	@Override
//	public int compareTo(Person o) {
//		return this.age-o.age;
//	}
//	
	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}
	

}