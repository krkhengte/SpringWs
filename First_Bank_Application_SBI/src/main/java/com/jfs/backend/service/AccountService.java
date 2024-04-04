package com.jfs.backend.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfs.backend.repository.AccountRepository;

@Component
public class AccountService {

//	private static final AccountRepository AccountRepository = null;

	@Autowired
	private static DisplayOption displayOpt;
	@Autowired
	private CreateNewAccount createNewAcc;
	@Autowired
	private LoginAccount loginAccount;
	@Autowired
	private AccountDetails accDet;
	@Autowired
	private DisplayAccountBalance dab;
	@Autowired
	private DepositBalance db;

	@Autowired
	private WithdrowBalance wb;

	@Autowired
	private TransferAmmount ta;
	public void display() {

		System.out.println("****Welcome To SBI(State Bank Of India)****");
		Scanner sc = new Scanner(System.in);
		displayOpt.displayOptions();
		String dwc = "yes";
		do {
			System.out.print("Enter Your Option as Given Above :");
			char Options = sc.next().charAt(0);

			switch (Options) {

			case '1':

				loginAccount.loginAcc();

				break;

			case '2':

				createNewAcc.createNewAcc();

				break;
			case '3':

				accDet.displayAccDetails();

				break;
			case '4':

				dab.displayAccBal();

				break;
			case '5':

				db.depositBalance();

				break;
			case '6':
				wb.withdrowAmmount();
				break;
			case '7':

				ta.transferAmmountToAnotherAccount();

				break;
			default:
				System.out.println("Invalid input");
				break;

			}
			System.out.print("Do You Want To Continue Press Yes/No : ");
			sc.nextLine();
			dwc = sc.nextLine();
		} while (dwc.equalsIgnoreCase("yes"));

		System.out.println();
		System.out.println("***************** Thank for Visit ****************");

	}

}
