package www.bcits.exceptionhandling.checkedExp.tryCatch;

public class TestA {
	public static void main(String[] args) {
		Person p1 = new Person();
		System.out.println("main started");
		try {
			p1.clone();
			System.out.println("Person is cloned");
			
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main ended");
	}

}
