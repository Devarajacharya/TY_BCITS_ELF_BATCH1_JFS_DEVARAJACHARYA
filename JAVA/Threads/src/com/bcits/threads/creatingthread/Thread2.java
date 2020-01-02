package com.bcits.threads.creatingthread;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("Thred is created..");
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

}
