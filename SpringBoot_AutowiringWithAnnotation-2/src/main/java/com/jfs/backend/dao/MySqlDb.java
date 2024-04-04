package com.jfs.backend.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("mysql")
public class MySqlDb implements IInterface {

	MySqlDb(){
		System.out.println("MySqlDb :: Constructor");
	}
	
	@Override
	public String data() {
		
		System.out.println("Data Get from MySql Db..");
		return "Data Transfer Successfully..";
	}

}
