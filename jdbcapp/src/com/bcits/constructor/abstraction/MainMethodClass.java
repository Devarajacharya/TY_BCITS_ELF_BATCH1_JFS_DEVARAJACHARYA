package com.bcits.constructor.abstraction;

public class MainMethodClass {

	public static void main(String[] args) {
		String dburl="one";
		Connection con = DriverManager.getConnection(dburl);
	    Statement stmt =con.createStatement();
	    stmt.method1();
		
	}
}
