package com.bcits.jdbcapp.connection;

public class MainMethodClass {
	
	public static void main(String[] args) {
		String dburl = "two";
		Connection ref = DriverManager.getConnection(dburl);
		ref.print();
		
		
	}

}
