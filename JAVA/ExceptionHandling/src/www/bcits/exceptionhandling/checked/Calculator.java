package www.bcits.exceptionhandling.checked;

public class Calculator {
	public void division(int a,int b) {
		try {
			Class.forName("Person");
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");		}
	}

}
