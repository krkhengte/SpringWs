package jfs.backend;

public class Debit_Card_Payment implements IPayment{
	@Override
	public String pay(double ammount) {
		
		return "Payment Successfull Through DebitCard";
	}

}
