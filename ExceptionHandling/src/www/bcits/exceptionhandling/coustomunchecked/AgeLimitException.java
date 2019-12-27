package www.bcits.exceptionhandling.coustomunchecked;

public class AgeLimitException extends RuntimeException {
	String msg = "Age is less than 18";

	public AgeLimitException() {
		super();
	}
	public AgeLimitException(String msg) {
		this.msg = msg;
	}
	String getMsg() {
		return this.msg;
	}

	
	

}
