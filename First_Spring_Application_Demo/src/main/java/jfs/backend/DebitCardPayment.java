package jfs.backend;

public class DebitCardPayment implements IPayment {

	@Override
	public String pay(int ammount) {
		
		return "Payment Successfully Through DebitCard...";
	}

}
