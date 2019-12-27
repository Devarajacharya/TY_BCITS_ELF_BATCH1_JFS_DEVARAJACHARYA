package com.bcits.threads.creatingthread;

public class TestThread3 {
		public static void main(String[] args) {
			System.out.println("main started");
			Thread3 t1 = new Thread3();
			Thread3 t2 = new Thread3();
			Thread t3 = new Thread(t1);
			Thread t4 = new Thread(t2);
			t3.start();
			t4.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t1.leaveMe();
			System.out.println("main ended");
			
		}

	
}
