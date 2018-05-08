package com.project.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class H2RestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/createTable")
	public String createTable() {
		try {
		jdbcTemplate.execute("CREATE TABLE CUSTOMERINFO (CustID int, LastName varchar(255), FirstName varchar(255), City varchar(255));");	
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			return "Error creating the table! Please make sure the Database name doesn't already exist!";
		}
		return "Table Has been Successfully Created!";
	}
	
	@GetMapping("/insertData")
	public String insertData() {
		
		try {
			jdbcTemplate.execute("Insert into CUSTOMERINFO values (1, 'Nigade', 'Bhagyashree', 'Pune');");
		} catch (Exception e) {
			e.printStackTrace();
			return "Error Occured in Inserting Data!";
		}
		return  "Data Entered in the Table!";
	}
}
