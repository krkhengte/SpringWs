package com.jfs.backend.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("mysql")
// @Primary //If we don't want to use @Qualifier then we should specify @Primary for one bean to get injected
public class MysqlReportDaoIMPL implements ReportDao {

	MysqlReportDaoIMPL() {

		System.out.println("ReportDaoIMPL :: Constructor");
	}

	@Override
	public String findData() {
		System.out.println("Featching Data From MYsql DB....");
		return "Report Data";
	} 

}
