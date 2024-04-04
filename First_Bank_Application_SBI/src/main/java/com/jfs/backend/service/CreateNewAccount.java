package com.jfs.backend.service;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfs.backend.entity.Account;
import com.jfs.backend.repository.AccountRepository;

@Component
public class CreateNewAccount {

	@Autowired
	private AccountRepository accRep;

	@Autowired
	private Account ac;

	Scanner sc = new Scanner(System.in);

	public void createNewAcc() {

		String accNum = "";
		Random rnd = new Random();
		String accNum1 = "";

		Stack st = new Stack();
		int k = 0;
		for (int i = 0; i < 5; i++) {

			st.add(k = rnd.nextInt(10));

		}
		Enumeration e = st.elements();

		while (e.hasMoreElements()) {
			accNum1 = String.valueOf(e.nextElement());
			// System.out.print(accNum1);
			accNum = accNum.concat(accNum1);
		}

		System.out.print("Enter Deposit AccBalance :");
		float accBalance = sc.nextFloat();
		sc.nextLine();

		System.out.print("Enter Your Email Id :");
		String userEmail = sc.nextLine();

		System.out.print("Enter Your Gender :");
		String Gender = sc.nextLine();

		System.out.print("Enter Your userMobile :");
		String userMobile = sc.nextLine();

		System.out.print("Enter Your holderName :");
		String holderName = sc.nextLine();

		System.out.print("Enter Your UserName :");
		String username = sc.nextLine();

		System.out.print("Enter Your Password :");
		String password = sc.nextLine();

		ac.setAccountbalance(accBalance);
		ac.setHolderemailid(userEmail);
		ac.setHoldergender(Gender);
		ac.setHoldermobile(userMobile);
		ac.setHoldername(holderName);
		ac.setUsername(username);
		ac.setPassword(password);
		ac.setAccountnumber(accNum);

		accRep.save(ac);

		if (accNum.isEmpty() == false) {

			System.out.println("Account Successfully Created....");
			System.out.println("Remind Your Account Number :" + accNum);

		} else {
			System.out.println("Failed To Create Account Please Try Again..");
		}

	}
}
