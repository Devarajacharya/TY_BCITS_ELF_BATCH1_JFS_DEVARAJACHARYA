package www.bcits.exceptionhandling.coustomChecked;

public class SBIATM {
	public static void main(String[] args) {
		ATMSimulator a1 = new ATMSimulator();
		System.out.println("main Started");
		try {
			a1.deposite(41000);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMsg());
		}
		System.out.println("Main ended");
	}

}
