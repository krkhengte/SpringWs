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
public class TransferAmmount {

	Scanner sc = new Scanner(System.in);

	@Autowired
	private AccountRepository accRep;


	private Account acc=new Account();

	public void transferAmmountToAnotherAccount() {

		System.out.print("Enter Account Number From Transfer Ammount :");
		String fromAcc = sc.nextLine();

		System.out.print("Enter Account Number To Transfer Ammount :");
		String toAcc = sc.nextLine();

		System.out.print("Enter Transfer Ammount :");
		float transferAmount = sc.nextFloat();

		Account fba = accRep.findByAccountnumber(fromAcc);
	
		Account fba1 = accRep.findByAccountnumber(fromAcc);

		Account fba2 = accRep.findByAccountnumber(toAcc);

		Float accountbalance_fromAcc = fba1.getAccountbalance();

		float updBalance_fromAcc = accountbalance_fromAcc - transferAmount;

		fba1.setAccountbalance(updBalance_fromAcc);
		accRep.save(fba1);

		Float accountbalance_toAcc = fba2.getAccountbalance();
		float upBalance_toAcc = accountbalance_toAcc + transferAmount;

		fba2.setAccountbalance(upBalance_toAcc);
		accRep.save(fba2);

		Float newUpBala = fba2.getAccountbalance();

		if (newUpBala == upBalance_toAcc) {
			System.out.println("Amount Successfully Transfer......");
		} else {
			System.out.println("Transfer Failed...");
		}
	}

}
