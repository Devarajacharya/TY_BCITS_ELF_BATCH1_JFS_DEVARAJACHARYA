package com.bcits.myproperties.common;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertieFileReader {

	public static void main(String[] args) {
		try {
			FileInputStream inputFile = new FileInputStream("dbinfo.properties");
			Properties properties = new Properties();
			properties.load(inputFile);
			System.out.println("Drive Name : " + properties.getProperty("driveNm"));
			System.out.println("URL        : " + properties.getProperty("dburl"));
			System.out.println("User       : " + properties.getProperty("user"));
			System.out.println("Password   : " + properties.getProperty("password"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
