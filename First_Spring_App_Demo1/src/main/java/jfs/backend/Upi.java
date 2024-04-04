package jfs.backend;

public class Upi implements IPayment{

	@Override
	public String pay(int ammount) {

		return "Payment Done Successfully Through Upi";
		
	}

}
