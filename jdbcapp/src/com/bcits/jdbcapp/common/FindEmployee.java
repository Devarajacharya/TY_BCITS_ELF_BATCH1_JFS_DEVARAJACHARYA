package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FindEmployee {

	public static void main(String[] args) {
		Connection con = null;
//		Statement stmt = null;
		Statement stmt =null;
		ResultSet rs = null;
		try {
			/*
			 * Driver driver = new Driver(); DriverManager.deregisterDriver(driver);
			 */
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://Localhost:3306/employee_managment_info?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			

			String query = "select * from employee_primary_info " + "where empid = 100";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
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

				System.out.println("Employee ID   : " + id);
				System.out.println("Employee name : " + name);
				System.out.println("Mobile Number : " + mobileno);
				System.out.println("DOB           : " + dob);
				System.out.println("DOJ           : " + doj);
				System.out.println("Designation   : " + desig);
				System.out.println("Blood Group   : " + blood);
				System.out.println("Dept ID       : " + deptno);
				System.out.println("Manager ID    : " + managerid);
				System.out.println("Salary        : " + sal);
				System.out.println("Personal Mail : " + mail);
				System.out.println();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
