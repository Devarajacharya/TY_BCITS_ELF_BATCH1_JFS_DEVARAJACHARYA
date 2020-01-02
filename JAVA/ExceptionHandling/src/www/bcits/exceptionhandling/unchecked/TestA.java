package www.bcits.exceptionhandling.unchecked;

public class TestA {
	static String name;

	public static void main(String[] args) {
		System.out.println("main started");
//		try {
//			System.out.println(100/0);
//			System.out.println(name.length());
//		} catch (ArithmeticException e1) {
//			System.out.println(e1.getMessage());
//		} catch (NullPointerException e2) {
//			System.out.println(e2.getMessage());
//		}

//		try {
//			System.out.println(name.length());
//			System.out.println(100/0);
//		} catch (ArithmeticException | NullPointerException e1) {
//			System.out.println(e1.getMessage());
//		} 

		try {
			System.out.println(name.length());
			System.out.println(100 / 0);
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		System.out.println("main ended");
	}

}
