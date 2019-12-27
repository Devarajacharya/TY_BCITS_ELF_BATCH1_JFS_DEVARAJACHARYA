package www.bcits.exceptionhandling.checkedExp.tryCatch;

public class TestB {
	public static void main(String[] args) {
		try {
		Class.forName("Student");
		Student s1 = new Student();	
		s1.clone();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
