package www.bcits.practice.sixth;

public class Baby {
	String icecream;

	public Baby(String icecream) {
		super();
		this.icecream = icecream;
	}

	@Override
	public String toString() {
		return "Baby is getting " + icecream + " flavoured IceCream" ;
	}
	
}
