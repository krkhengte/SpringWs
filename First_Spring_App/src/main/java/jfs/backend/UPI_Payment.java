package jfs.backend;

public class UPI_Payment implements IPayment{
	
	@Override
	public String pay(double ammount) {
		
		return "Payment Successfull Through UPI";
	}

}
