package jfs.backend;

public class CreditCardPayment implements IPayment {

	@Override
	public String pay(int ammount) {

		return "Payment Successfully Through CreditCard...";
	}

}
