package com.bcits.discom.trarifflogic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MainClass {

	static HashMap<String, Consumer> map = new HashMap<String, Consumer>();
	static long prev;
	static long pres;
	static double billAmt;
	static long totalUnit;
	private static Scanner scan;
	static int count;

	public static void main(String[] args) {
		if (Employee.employeeLogin()) {
			while (true) {

				scan = new Scanner(System.in);
				System.err.println("\n" + "Select Choice ");
				System.err.println("1. Generate Bill ");
				System.err.println("2. Show all Details of Consumer");
				System.err.println("3. Logout ");
				System.err.print("Choose : ");
				switch (Integer.parseInt(scan.nextLine())) {
				case 1:
					System.out.print("\n" + "Enter the name : ");
					String name = scan.nextLine();
					if (Validation.nameValidation(name)) {
						System.err.println("\n" + "Please fill the name ..");
						break;
					}
					System.out.print("Enter RR / Meter Number : ");
					String rrNum = scan.nextLine();
					if (Validation.rrValidation(rrNum)) {
						System.err.println("\n" + "Invalid RR number..!!");
						break;
					}
					System.out.println("\n" + "Select the type of Consumer");
					System.out.println("1. Residential consumers ");
					System.out.println("2. Commercial consumers");
					System.out.println("3. Industries consumers");
					System.out.print("Choose : ");
					switch (Integer.parseInt(scan.nextLine())) {
					case 1:

						System.out.print("\n" + "Enter the Previous reading : ");
						prev = scan.nextLong();
						System.out.print("Enter the Presence reading : ");
						pres = scan.nextLong();
						totalUnit = pres - prev;
						billAmt = BillGenerator.residentialConsumer(totalUnit);
						Consumer consumer1 = new Consumer(rrNum, name, "Residential", prev, pres, totalUnit, billAmt);
						map.put(rrNum, consumer1);
						System.out.println("\n" + "<--Press Enter to Generate Bill-->");
						scan.nextLine();
						scan.nextLine();
						System.out.println(map.get(rrNum));
						break;

					case 2:
						System.out.print("\n" + "Enter the Previous reading : ");
						prev = scan.nextLong();
						System.out.print("Enter the Presence reading : ");
						pres = scan.nextLong();
						totalUnit = pres - prev;
						billAmt = BillGenerator.commercialConsumer(totalUnit);
						Consumer consumer2 = new Consumer(rrNum, name, "Residential", prev, pres, totalUnit, billAmt);
						map.put(rrNum, consumer2);
						System.out.println("\n" + "<--Press Enter to Generate Bill-->");
						scan.nextLine();
						scan.nextLine();
						System.out.println(map.get(rrNum));
						break;

					case 3:
						System.out.print("\n" + "Enter the Previous reading : ");
						prev = scan.nextLong();
						System.out.print("Enter the Presence reading : ");
						pres = scan.nextLong();
						totalUnit = pres - prev;
						billAmt = BillGenerator.industriesConsumer(totalUnit);
						Consumer consumer3 = new Consumer(rrNum, name, "Residential", prev, pres, totalUnit, billAmt);
						map.put(rrNum, consumer3);
						System.out.println("\n" + "<--Press Enter to Generate Bill-->");
						scan.nextLine();
						scan.nextLine();
						System.out.println(map.get(rrNum));
						break;

					default:
						System.out.println("Invalid Choice !!");
						break;
					}
					break;

				case 2:
					System.out.println("-------------All Details--------------");
					Set keys = map.keySet();
					Iterator il = keys.iterator();
					while (il.hasNext()) {
						System.out.println(map.get(il.next()));
						System.out.println("-------------------------------------");
					}
					break;
				case 3: System.err.println("\n"+"You have sucessfully logged out..");
				        Employee.employeeLogin();
						break;

				default:
					System.out.println("Invalid Choice !!");
					break;
				}
				scan.getClass();
			}
		} else {
			if (++count != 3) {
				System.err.println("\n" + "Invalid Employee ID / Designation !!" + "\n");
				main(args);
			} else {
				System.err.println("\n" + "You are reached maximum login attempts.");
			}
		}
	}

}
