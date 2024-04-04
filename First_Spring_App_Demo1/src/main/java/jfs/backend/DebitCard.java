package jfs.backend;

public class DebitCard implements IPayment{

	@Override
	public String pay(int ammount) {
		return "Payment Done Successfully Through DebitCard";
		
	}

}
