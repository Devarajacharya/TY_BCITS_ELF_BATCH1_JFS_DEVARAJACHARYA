package com.bcits.jdbcapp.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class PrepareStatementDelete {

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

			String query = "delete from employee_primary_info " + "where empid = ?";
			pstmt = con.prepareStatement(query);

			System.out.print("Enter the Employee Id : ");
			sd = new Scanner(System.in);
			int eid = sd.nextInt();
			pstmt.setInt(1, eid);
			int rs = pstmt.executeUpdate();
			if (rs != 0) {
				System.out.println("Profile is updated...");
			}else {
				System.err.println("Enter the valid Employee ID");
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
