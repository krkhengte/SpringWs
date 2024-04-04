package jfs.backend;

public class CreditCard implements IPayment{

	@Override
	public String pay(int ammount) {
		
		return "Payment Done Successfully Through CreditCard";
	}

}
