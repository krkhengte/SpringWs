package com.jfs.backend.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class DisplayOption {

	public static void displayOptions() {

		System.out.println("1: Login Your Account (Existing User Can Login..)");
		System.out.println("2: Create Your New Account (New User can Register..)");

	}

	public static void displayOptions1() {

		System.out.println("3: Display your Account Details");
		System.out.println("4: Display Your Account Balance");
		System.out.println("5: Deposite Balance in your Account");
		System.out.println("6: Withdrow Balance");
		System.out.println("7: Transfer Acc Balance to Another Bank Account");
	}
}
