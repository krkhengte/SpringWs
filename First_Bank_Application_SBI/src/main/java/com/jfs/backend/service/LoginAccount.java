package com.jfs.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jfs.backend.FirstBankApplicationSbiApplication;
import com.jfs.backend.entity.Account;
import com.jfs.backend.repository.AccountRepository;

@Component
public class LoginAccount {

	Scanner sc = new Scanner(System.in);
	@Autowired
	private Account acc;

	@Autowired
	private DisplayOption disOpt;

	@Autowired
	private AccountRepository accRep;

	public void loginAcc() {

		String inputCapture = "";
		String capture = "";

		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random rnd = new Random();
		char[] otp = new char[6];
		for (int i = 0; i < 6; i++) {

			otp[i] = alpha.charAt(rnd.nextInt(alpha.length()));
		}
		capture = new String(otp);

		System.out.print("Enter Your UserName : ");
		String userName = sc.nextLine();

		System.out.print("Enter Your Password : ");
		String password = sc.nextLine();

		System.out.println("Captcha :" + capture);

		System.out.print("Enter Capture as per Given : ");
		inputCapture = sc.nextLine();

		List<Account> fbu = accRep.findByUsernameAndPassword(userName, password);

//		List<Account> fbu = accRep.findByUsername(userName);
//		List<Account> fbp = accRep.findByPassword(password);

		if (fbu.isEmpty() == false && capture.equals(inputCapture)) {
			System.out.println("Login Successfull..");

			System.out.println("*******************************************");
			disOpt.displayOptions1();

		} else {
			System.out.println("Invalid User and Password...(please entered Valid Capture)!");
		}

	}
}
