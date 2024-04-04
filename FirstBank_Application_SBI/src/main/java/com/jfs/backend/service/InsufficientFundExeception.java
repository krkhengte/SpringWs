package com.jfs.backend.service;

public class InsufficientFundExeception extends Exception {
	
	public InsufficientFundExeception(String msg){
		
		System.out.println(msg);
		
	}

	public InsufficientFundExeception(Object msg) {
	}


}


