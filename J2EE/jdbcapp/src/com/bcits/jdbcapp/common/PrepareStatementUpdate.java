package com.bcits.jdbcapp.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class PrepareStatementUpdate {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner sd = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dburl = "jdbc:mysql://Localhost:3306/employee_managment_info?";
			FileInputStream f1 = new FileInputStream("db.properties");
			Properties p1 = new Properties();
			p1.load(f1);
			con = DriverManager.getConnection(dburl, p1);

			String query = "update employee_primary_info "
							+ "set emp_name = ? " 
							+ "where empid = ?";
			pstmt = con.prepareStatement(query);

			sd = new Scanner(System.in);
			System.out.println("Enter the Name to change : ");
			String name = sd.nextLine();
			System.out.print("Enter the Employee Id : ");
			int eid = sd.nextInt();
			pstmt.setString(1, name);
			pstmt.setInt(2, eid);
			int rs = pstmt.executeUpdate();
			if (rs != 0) {
				System.out.println("Profile is updated...");
			} else {
				System.err.println("Enter the valid Employee ID.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (sd != null) {
					sd.close();
				}
			} catch (Exception e2) {
			}
		}

	}
}
