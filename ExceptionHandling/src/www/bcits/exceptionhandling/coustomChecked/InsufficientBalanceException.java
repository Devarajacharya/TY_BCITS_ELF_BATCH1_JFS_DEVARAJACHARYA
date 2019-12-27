package www.bcits.exceptionhandling.coustomChecked;

public class InsufficientBalanceException extends Exception {
	String msg = "Insufficient Balance";

	public InsufficientBalanceException() {
		super();
	}

	public InsufficientBalanceException(String msg) {
		super();
		this.msg = msg;
	}

	String getMsg() {
		return msg;
	}

}
