package www.bcits.exceptionhandling.coustomChecked;

public class ATMSimulator {
	int amount =40000;
	public void deposite(int bal) throws InsufficientBalanceException {
		if(amount >= bal) {
			System.out.println("Withdraw successfully");
		} else {
			throw new InsufficientBalanceException();
		}
		
	}

}
