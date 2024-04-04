package jfs.backend;

public class BillCollector{

	private IPayment payment;
	
	public void setPayment(IPayment payment) {
		this.payment=payment;
	}
	
//	public BillCollector(IPayment payment) {
//		this.payment=payment;
//	}
	
	public void collectPayment(int ammount) {
		
		String str = payment.pay(ammount);
		
		System.out.println(str);
		
	}

}
