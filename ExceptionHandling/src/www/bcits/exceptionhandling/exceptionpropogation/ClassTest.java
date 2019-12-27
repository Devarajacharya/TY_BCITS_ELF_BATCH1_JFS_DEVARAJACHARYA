package www.bcits.exceptionhandling.exceptionpropogation;

public class ClassTest {
	public static void main(String[] args) {
		System.out.println("main started");
		try {
			ClassA.a();
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main ended");
	}

}
