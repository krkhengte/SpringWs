package com.jfs.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jfs.backend.dao.IInterface;


@Service
public class ServiceDemo {
	
	
	public IInterface getIinterface() {
		return iinterface;
	}


//	public void setIinterface(IInterface iinterface) {
//		this.iinterface = iinterface;
//	}

	@Autowired
	@Qualifier("mysql")
	private IInterface iinterface;
	
	
	public void displayData() {
		
		String data = iinterface.data();
		System.out.println(data);
		
	}

}
