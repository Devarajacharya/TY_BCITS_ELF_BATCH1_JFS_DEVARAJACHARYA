package www.bcits.exceptionhandling.unchecked;

public class NestedTryCatch {
	public static void main(String[] args) {
		String name = null;
		System.out.println("main started");
		try {
			try {
				System.out.println(100 / 0);
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(name.length());
		} catch (NullPointerException e1) {
			System.out.println(e1.getMessage());
		}
		System.out.println("main ended");

	}

}
