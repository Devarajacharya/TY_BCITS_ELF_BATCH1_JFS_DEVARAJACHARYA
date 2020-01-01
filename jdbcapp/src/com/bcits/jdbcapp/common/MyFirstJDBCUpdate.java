package com.bcits.jdbcapp.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class MyFirstJDBCUpdate {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			FileInputStream f1 = new FileInputStream("db.properties");
			Properties pr = new Properties();
			pr.load(f1);
			String dburl = "jdbc:mysql://Localhost:3306/employee_managment_info?";
			con = DriverManager.getConnection(dburl, pr);

			String query = "update employee_primary_info " 
						    + "set emp_name = 'ranju' " 
							+ "where empid =100";

			stmt = con.createStatement();
			int res = stmt.executeUpdate(query);
			if (res != 0) {
				System.out.println("Profile Updated..");
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
