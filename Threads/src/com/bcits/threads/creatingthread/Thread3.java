package com.bcits.threads.creatingthread;

public class Thread3 implements Runnable{

	@Override
	synchronized public void run() {
		System.out.println("Thred is created..");
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	synchronized void leaveMe() {
		System.out.println("Notify called");
		notifyAll();
		
	}
	

}