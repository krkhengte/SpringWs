package com.jfs.backend;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;

import com.jfs.backend.entity.UserData;
import com.jfs.backend.repository.UserRepository;

@SpringBootApplication
public class DataJpaApp2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DataJpaApp2Application.class, args);
		UserRepository ur = context.getBean(UserRepository.class);
		
//		Scanner sc=new Scanner(System.in);
//		String dwc="Yes";
//		do {
//		System.out.println("Enter Your userId");
//		int userId=sc.nextInt();
//		sc.nextLine();
//		System.out.println("Enter Your userName");
//		String userName=sc.nextLine();
//		
//		System.out.println("Enter Your userGender");
//		String userGender=sc.nextLine();
//		
//		System.out.println("Enter Your userAge");
//		int userAge=sc.nextInt();
//		sc.nextLine();
//		System.out.println("Enter Your userCountry");
//		String userCountry=sc.nextLine();
//		
//		
//		UserData ud=new UserData(userId, userName, userGender, userAge, userCountry);
//		ur.save(ud);
//		System.out.println("Do You Want To Add More If Yes Press Yes/No");
//		dwc=sc.nextLine();
//		}while(dwc.equalsIgnoreCase(dwc));
		
		// Get Single Record using Primary key
		

		
		Optional<UserData> byId = ur.findById(107);
		if(byId.isPresent()) {
			System.out.println(byId.get());
		}else {
			System.out.println("Record Is Not Available");
		}
		
		// Get Multiple Record using Primary key
		
		Iterable<UserData> findAllById = ur.findAllById(Arrays.asList(101,102,103));
		findAllById.forEach(e->{
			System.out.println(e);
		});
		
		System.out.println("************************************************");
		
		// Retrive all The record form the table
		
		Iterable<UserData> findAll = ur.findAll();
		
		findAll.forEach(e->{
			System.out.println(e);
		});
		
		System.out.println("************************************************");
		
		// Find Total Record inside the table
		
		long count = ur.count();
		System.out.println("Total Record in Table :" + count);
		
		System.out.println("************************************************");
		
		// Find The Given Record is Exist or Not
		
		boolean existsById = ur.existsById(105);
		System.out.println("Record is Exist or Not :" + existsById );
		
		// Delete The record inside the table
		
		ur.deleteById(102);
		
		System.out.println("************************************************");
		
		UserData ud1=new UserData(106, "Lio", "Female", 22, "Canada");
		UserData ud2=new UserData(107, "Sam", "Male", 26, "France");
		ur.saveAll(Arrays.asList(ud1,ud2));
		
		System.out.println("************************************************");
		// to get the data without using primary key variable
		
//		List<UserData> findbycountry = ur.findByCountry("India");
//		
//		findbycountry.forEach(e-> System.out.println(e));
		
		System.out.println("************************************************");
		
		List<UserData> findByAge = ur.findByUserage(26);
		
		findByAge.forEach(e->System.out.println(e));
		
		System.out.println("************************************************");
		
		List<UserData> findByUserageGreaterThanEqual = ur.findByUserageGreaterThanEqual(23);
		findByUserageGreaterThanEqual.forEach(e->System.out.println(e));
		
		System.out.println("************************************************");
		
		List<UserData> list = ur.findByCountryIn(Arrays.asList("India","USA"));
		
		list.forEach(e->System.out.println(e));
		
		System.out.println("************************************************");
		
		List<UserData> findByCountryAndUserage = ur.findByCountryAndUserage("India", 22);
		findByCountryAndUserage.forEach(e->{
			System.out.println(e);
		});
		
		
		System.out.println("************************************************");
		
		List<UserData> findByCountryAndUserageAndGender = ur.findByCountryAndUserageAndGender("India", 22, "Male");
		
		
		findByCountryAndUserageAndGender.forEach(e->System.out.println(e));
		
		
	}

}
