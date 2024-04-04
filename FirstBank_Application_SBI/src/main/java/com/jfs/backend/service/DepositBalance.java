package com.jfs.backend.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jfs.backend.entity.Account;
import com.jfs.backend.repository.AccountRepository;

//@Component
@Service
public class DepositBalance {

	Scanner sc = new Scanner(System.in);

	@Autowired
	private AccountRepository accRep;

	
	Account acc=new Account();

	public void depositBalance() {

		System.out.print("Enter Your Account Number :");
		String accNum = sc.nextLine();
		System.out.print("Enter Deposite Balance :");
		float depBalance = sc.nextFloat();
		sc.nextLine();

		Account findByAccountnumber = accRep.findByAccountnumber(accNum);

		String accountnumber = findByAccountnumber.getAccountnumber();
		Float TotalAccBalance = null;
		Float upBal = null;
		
		if (accountnumber.equals(accNum)) {

			Float accountbalance = findByAccountnumber.getAccountbalance();

			TotalAccBalance = accountbalance + depBalance;

			findByAccountnumber.setAccountbalance(TotalAccBalance);

			accRep.save(findByAccountnumber);

			upBal = findByAccountnumber.getAccountbalance();

			// accRep.save(upBal);
		}
		
		if (upBal == TotalAccBalance) {

			System.out.println("Ammount Deposited Successfully...");
		}

		else {
			System.out.println("Failed to Deposit.....");
		}

	}

}
