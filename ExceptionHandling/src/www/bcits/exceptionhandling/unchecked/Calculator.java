package www.bcits.exceptionhandling.unchecked;

public class Calculator {
	public void add(int a, int b) {
		System.out.println(a+b);
	}
	
	public void division(int a,int b) {
		try {
			System.out.println(a/b);
		} catch (Exception e) {
			System.out.println("MATH ERROR");
		}
	}

}
