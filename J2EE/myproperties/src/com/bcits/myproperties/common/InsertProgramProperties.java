package com.bcits.myproperties.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class InsertProgramProperties {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		FileInputStream inputFile = null;
		Properties properties = new Properties();
		try {
			inputFile = new FileInputStream("dbinfo.properties");

			properties.load(inputFile);
			Class.forName(properties.getProperty("driveNm")).newInstance();

			con = DriverManager.getConnection(properties.getProperty("dburl"), properties.getProperty("user"),
					properties.getProperty("password"));

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
