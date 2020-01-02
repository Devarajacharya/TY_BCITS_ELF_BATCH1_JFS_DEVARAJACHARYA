package www.bcits.exceptionhandling.coustomunchecked;

public class Election {
	public void vote(int age) {
		if(age > 18){
			System.out.println("Allow him to vote");
		} else {
			throw new AgeLimitException();
		}
	}

}
