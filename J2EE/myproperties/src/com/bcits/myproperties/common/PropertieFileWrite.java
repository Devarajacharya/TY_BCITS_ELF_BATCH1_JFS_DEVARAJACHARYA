package com.bcits.myproperties.common;

import java.io.FileOutputStream;
import java.util.Properties;

public class PropertieFileWrite {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("dbinfo.properties");
			Properties properties = new Properties();
			properties.setProperty("driveNm", "com.mysql.jdbc.Driver");
			properties.setProperty("dburl", "jdbc:mysql://Localhost:3306/employee_managment_info?");
			properties.setProperty("user", "root");
			properties.setProperty("password", "root");

			properties.store(fos, "DB detail");
			System.out.println("File Created.. ");

		} catch (Exception e) {
			;
			e.printStackTrace();
		}
	}
}
