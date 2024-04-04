package com.jfs.backend.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("oracle")
//@Primary
public class OracleDb implements IInterface{

	OracleDb(){
		System.out.println("OracleDb :: Constructor");
	}
	
	@Override
	public String data() {
		System.out.println("Data Get Form Oracle Db");
		return "Data Transfer Successfully..";
	}

}
