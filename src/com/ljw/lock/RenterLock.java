package com.ljw.lock;

import java.util.concurrent.locks.ReentrantLock;

public class RenterLock implements Runnable{
	
	public static ReentrantLock look = new ReentrantLock();
	
	public static int i = 0;
	
	
	

	@Override
	public void run() {
		for (int j = 0; j < 100; j++) {
			look.lock();//允许锁2次，锁2次，也需要解2次
			try {
				i++;
			} finally {
				look.unlock();
			}
			
			
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		RenterLock r1 = new RenterLock();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(i);
		
		
	}

}
