package www.bcits.exceptionhandling.unchecked;

public class TestCalculator {
	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		System.out.println("Main started");
		c1.division(100, 5);
		c1.division(100, 0);
		c1.division(20, 5);
		c1.division(50, 10);
		System.out.println("main ended");
		
	}

}
