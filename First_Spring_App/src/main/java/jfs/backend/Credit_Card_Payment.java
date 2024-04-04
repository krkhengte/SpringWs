package jfs.backend;

public class Credit_Card_Payment  implements IPayment{

	@Override
	public String pay(double ammount) {
		
		return "Payment Successfull Through CreditCard";
	}
	
	

}
