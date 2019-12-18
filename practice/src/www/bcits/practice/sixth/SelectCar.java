package www.bcits.practice.sixth;

import java.util.Scanner;

public class SelectCar {

		private static Scanner sd;

		public static void main(String[] args) {
			sd = new Scanner(System.in);
			System.out.println("select the car for Driving  :\n 1.Audi \n 2.Benz");
			System.out.print("Enter your choice : ");
			int opt =sd.nextInt();
			Driver d = new Driver();
			if(opt == 1) {
				d.drive(new Audi());		
			} else {
				d.drive(new Benz());	
			}
				

		}

}
