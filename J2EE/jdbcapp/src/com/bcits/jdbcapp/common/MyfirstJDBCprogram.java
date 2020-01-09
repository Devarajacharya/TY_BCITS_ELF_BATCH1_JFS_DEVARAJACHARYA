 package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MyfirstJDBCprogram {

	public static void main(String[] args) {
		Connection con =null;
		ResultSet rs =null;
		Statement stmt =null;
		try {
			//Load the driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			//Establish the DB connection via Driver
			
			//String dbUrl = "jdbc:mysql://localhost:3306/employee_managment_info?user=root&password=root";
			String dburl = "jdbc:mysql://Localhost:3306/employee_managment_info?";
			con = DriverManager.getConnection(dburl, "root", "root");

			//Issue The SQL Query using Connection
			String query = "select * from employee_primary_info";
			stmt = con.createStatement();
			rs =stmt.executeQuery(query);

			//Process the result return by the SQl query
			while(rs.next()){
				int id = rs.getInt("empid");
				String name = rs.getString("empname");
				long mobileno = rs.getLong("mobile_no");
				Date dob = rs.getDate("DOB");
				Date doj = rs.getDate("DOJ");
				String desig = rs.getString("designation");
				String blood = rs.getString("blood_group");
				int deptno = rs.getInt("deptid");
				int managerid = rs.getInt("manager_id");
				double sal = rs.getDouble("sal");
				String mail = rs.getString("official_mail");

				System.out.println("Employee id   : "+id);
				System.out.println("Employee name : " +name);
				System.out.println("Mobile number : "+mobileno);
				System.out.println("DATE OF BIRTH : "+dob);
				System.out.println("DATE OF Join  : "+doj);
				System.out.println("Designation   : "+desig);
				System.out.println("Blood Group   : "+blood);
				System.out.println("Dept ID       : "+deptno);
				System.out.println("Manager ID    : "+managerid);
				System.out.println("Salary        : "+sal);
				System.out.println("Personal Mail : "+mail);
				System.out.println();

			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			//close all JDBC object
			try {
				if(con != null) {
					con.close();
				}
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
