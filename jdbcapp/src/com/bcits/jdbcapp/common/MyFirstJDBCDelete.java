package com.bcits.jdbcapp.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class MyFirstJDBCDelete {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			FileInputStream f1 = new FileInputStream("db.properties");
			Properties p1 = new Properties();
			p1.load(f1);
			String dburl ="jdbc:mysql://Localhost:3306/employee_managment_info?";
			con = DriverManager.getConnection(dburl, p1);
			String query = "delete from employee_primary_info "
						   +"where empid = 150";
			stmt = con.createStatement();
			int rs = stmt.executeUpdate(query);
			if(rs != 0) {
				System.out.println("Profile Updated......");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				
			} catch (Exception e2) {
			}
		}
		
	}
}
