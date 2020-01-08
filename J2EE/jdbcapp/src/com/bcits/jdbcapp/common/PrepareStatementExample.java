package com.bcits.jdbcapp.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class PrepareStatementExample {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sd = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://Localhost:3306/employee_managment_info?";
			FileInputStream f1 = new FileInputStream("db.properties");
			Properties p1 = new Properties();
			p1.load(f1);
			con = DriverManager.getConnection(dburl, p1);
			
			String query ="Select * from employee_primary_info "
						  + "where empid = ?";
			pstmt = con.prepareStatement(query);
			
//			pstmt.setInt(1,Integer.parseInt(args[0]) );

			System.out.print("Enter the Employee Id : ");
			sd = new Scanner(System.in);
			int eid = sd.nextInt();
			pstmt.setInt(1,eid );
			rs = pstmt.executeQuery();

			if(rs.next()) {
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
			}else {
				System.err.println("Employee Date Is Not Found....");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (sd != null) {
					sd.close();
				}
			} catch (Exception e2) {
			}
		}

	}
}
