package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepository;

@SpringBootApplication
public class DataJpaApp1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DataJpaApp1Application.class, args);
		
		PlayerRepository pr = context.getBean(PlayerRepository.class);
		
		Scanner sc=new Scanner(System.in);
		Player p1=new Player();
		System.out.println("Enter Your playerId");
		int playerId=sc.nextInt();
		sc.nextLine();
		p1.setPlayerId(playerId);
		System.out.println("Enter Your playerName");
		String playerName=sc.nextLine();
		p1.setPlayerName(playerName);
		System.out.println("Enter Your playerAge");
		int playerAge=sc.nextInt();
		p1.setPlayerAge(playerAge);
		sc.nextLine();
		System.out.println("Enter Your playerLocation");
		String playerLocation=sc.nextLine();
		p1.setLocation(playerLocation);
		
		pr.save(p1); //(Insert and Update) it is used also for Update the Record (Upsert Method)
		
		System.out.println("Recort Inserted.....");
		
	}

}
