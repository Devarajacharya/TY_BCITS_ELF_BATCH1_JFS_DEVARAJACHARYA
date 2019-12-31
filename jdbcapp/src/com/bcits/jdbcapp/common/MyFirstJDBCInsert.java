package com.bcits.jdbcapp.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class MyFirstJDBCInsert {
	
	public static void main(String[] args) {
		Connection con =null;
		Statement stmt =null;
		try {
			//Load Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//Establis the DB connection via Driver
			String dburl = "jdbc:mysql://Localhost:3306/employee_managment_info? ";
			FileInputStream fs = new FileInputStream("db.properties");
			Properties prop = new Properties();
			prop.load(fs);
			con = DriverManager.getConnection(dburl, prop);
			
			//Issue the Sql Query via connection
			String query= "insert into employee_project_info "
						  + "value (190,40)";
			stmt = con.createStatement();
			int res = stmt.executeUpdate(query);
			
			//Process the result return by the SQl query
			if(res != 0) {
				System.out.println("Profile Updated....");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}finally {
			//Close all JDBC objects
			try {
				if(con != null) {
					con.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			} catch (Exception e2) {
			}
		}
		
	}

}
