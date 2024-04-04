package com.jfs.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jfs.backend.dao.ReportDao;

@Component
public class ReportService {

	@Autowired
	@Qualifier("mysql")  // Feild injection
	private ReportDao reportdao;

	public ReportDao getReportdao() {
		return reportdao;
	}

	// Setter Injection
	
//	@Autowired
//	@Qualifier("oracle")  // It iS used to resolve the ambiguity problem
//	public void setReportdao(ReportDao reportdao) {
//		System.out.println("setReport() DAO report Called");
//		this.reportdao = reportdao;
//	}
	
	// Constructor Injection
	
	//@Autowired
	//@Qualifier("mysql")
//	public ReportService(ReportDao reportdao) {
//		super();
//		this.reportdao = reportdao;
//	}
	

	public void generateReport() {

		String findData = reportdao.findData();
		System.out.println("Generating Report..");
	}


}
