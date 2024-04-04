package com.jfs.backend.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfs.backend.entity.Account;
import com.jfs.backend.repository.AccountRepository;

import lombok.ToString;

@Component
public class DisplayAccountBalance {

	Scanner sc = new Scanner(System.in);

	@Autowired
	private AccountRepository accRep;

	@Autowired
	private Account acc;

	public void displayAccBal() {

		System.out.print("Enter Your UserName :");
		String userName = sc.nextLine();

		Account fbu = accRep.findByUsername(userName);

		Float accountbalance = fbu.getAccountbalance();

		System.out.println("*******************************************");

		System.out.println("Your Account Balance Is :" + accountbalance + " Rs.");

	}

}
