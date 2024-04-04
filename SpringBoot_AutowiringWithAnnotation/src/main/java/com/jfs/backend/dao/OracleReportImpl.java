package com.jfs.backend.dao;

import org.springframework.stereotype.Repository;

@Repository("oracle")
public class OracleReportImpl implements ReportDao{

	public OracleReportImpl() {
		System.out.println("OraclereportImple :: Constructors");
	}
	@Override
	public String findData() {
		System.out.println("Featching Data From Oracle DB....");
		return "Report Data";
	
	}

}
