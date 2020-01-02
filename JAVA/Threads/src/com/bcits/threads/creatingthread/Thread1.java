package com.bcits.threads.creatingthread;

public class Thread1 extends Thread{
	public void run() {
		System.out.println("Thred is created..");
		for (int i = 1; i < 5; i++) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
