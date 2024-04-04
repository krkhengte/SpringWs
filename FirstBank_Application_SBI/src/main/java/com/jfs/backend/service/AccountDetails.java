package com.jfs.backend.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jfs.backend.entity.Account;
import com.jfs.backend.repository.AccountRepository;

//@Component
@Service
public class AccountDetails {

	Scanner sc = new Scanner(System.in);
	@Autowired
	private AccountRepository accRep;

	public void displayAccDetails() {

		System.out.print("Enter Your Username :");
		String userName = sc.nextLine();

		Account fbu = accRep.findByUsername(userName);
		System.out.println("*******************************************");
		System.out.println("Account Number :" + fbu.getAccountnumber());
		System.out.println("Account Holder Name :" + fbu.getHoldername());
		System.out.println("Account Balance :" + fbu.getAccountbalance() + " Rs.");

	}
}
