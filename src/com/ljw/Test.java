package com.ljw;

import java.util.concurrent.CountDownLatch;

public class Test {
	
	private CountDownLatch ct = new CountDownLatch(2);
	

	public static void main(String args[]) {
		Test test = new Test();
		
		new Thread(){
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("1 over");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();
		new Thread(){
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("2 over");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();
		try {
			test.doMy();
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doMy() throws InterruptedException{
		ct.await();
		System.out.println("ljw");
	}
	

}