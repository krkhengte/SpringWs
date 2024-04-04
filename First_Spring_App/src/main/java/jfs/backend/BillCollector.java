package jfs.backend;

public class BillCollector {

	private IPayment payment;

	// to initialise the value of variable by using setter method

	public void setPayment(IPayment payment) {
		this.payment = payment;
	}

	// to initialise the value of variable by using Constructor

	public BillCollector(IPayment payment) {

		System.out.println("BillCollector Para Constructor are Executed..");
		this.payment = payment;
	}

	public void collectPayment(double ammount) {

		String str = payment.pay(ammount);
		System.out.println("Injected :: " + payment.getClass().getName());
		System.out.println(str);
	}

}
