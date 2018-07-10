package com.ljw.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondition implements Runnable{
	
	
	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();
	

	@Override
	public void run() {
		try {
			lock.lock();
			condition.await();
			System.out.println("Thread is going on!");
			
			
		} catch (Exception e) {
			System.out.println(e);	
		}finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
		
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		ReentrantLockCondition rtc =  new ReentrantLockCondition();
		Thread t1 = new Thread(rtc);
		t1.start();
		
		Thread.sleep(1000);
		
		
		//通知线程继续执行
		lock.lock();
		condition.signal();
		System.out.println("condition111");
		System.out.println("condition222");
		System.out.println("condition222");
		System.out.println("condition222");
		
		System.out.println("condition222");
		System.out.println("condition222");
		System.out.println("condition222");
		System.out.println("condition222");
		
		System.out.println("condition222");
		System.out.println("condition222");
		System.out.println("condition222");
		System.out.println("condition222");
		
		lock.unlock();
		System.out.println("222");
		System.out.println("222");
		System.out.println("222");
		System.out.println("222");
		System.out.println("222");
		System.out.println("222");
		System.out.println("222");
		System.out.println("222");
		System.out.println("222");System.out.println("222");
		System.out.println("222");
		System.out.println("222");
	}
	

}
