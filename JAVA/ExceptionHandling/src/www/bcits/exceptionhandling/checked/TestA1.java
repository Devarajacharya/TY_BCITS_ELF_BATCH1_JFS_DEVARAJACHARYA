package www.bcits.exceptionhandling.checked;

public class TestA1 {
	public static void main(String[] args) {
		System.out.println("main started");
		Calculator c1 = new Calculator();
		c1.division(100, 0);
		System.out.println("main ended");
		
	}

}
