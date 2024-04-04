package com.jfs.backend.service;

import java.util.Scanner;

import javax.naming.InsufficientResourcesException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jfs.backend.entity.Account;
import com.jfs.backend.repository.AccountRepository;

//@Component
@Service
public class WithdrowBalance {

	Scanner sc = new Scanner(System.in);
	@Autowired
	private AccountRepository accRep;


	private Account acc=new Account();

	public void withdrowAmmount() {

		System.out.print("Enter Your Account Number :");
		String accNum = sc.nextLine();
		System.out.print("Enter Withdrow Ammount :");
		float withdrowAmm = sc.nextFloat();
		sc.nextLine();

		Account findByAccountnumber = accRep.findByAccountnumber(accNum);
		float priBalance = findByAccountnumber.getAccountbalance();
		String accountnumber = findByAccountnumber.getAccountnumber();
		Float TotalAccBalance = null;
		Float upBal = null;
		boolean exp = false;

		if (priBalance <= withdrowAmm) {
			try {
				throw new InsufficientFundExeception("Your Account Balance is Less Than Withdrowal Balance");
			} catch (Exception e) {

				System.out.println("Your Account Balance is :" + findByAccountnumber.getAccountbalance());
				System.out.println("Please Enter Valid Ammount.");
				exp = true;
			}

		}
		if (exp == true) {

			System.out.print("Enter Your Account Number :");
			accNum = sc.nextLine();
			System.out.print("Enter Withdrow Ammount :");
			withdrowAmm = sc.nextFloat();
			sc.nextLine();

		}

		if (accountnumber.equals(accNum)) {

			Float accountbalance = findByAccountnumber.getAccountbalance();

			TotalAccBalance = accountbalance - withdrowAmm;

			findByAccountnumber.setAccountbalance(TotalAccBalance);

			accRep.save(findByAccountnumber);

			upBal = findByAccountnumber.getAccountbalance();

			// accRep.save(upBal);
		}

		if (upBal == TotalAccBalance) {

			System.out.println("Ammount Withdrow Successfully...");
		}

		else {
			System.out.println("Failed to Withdrowal.....");
		}

	}
}
