package com.ljw.lock;

import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable{

	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	
	int lock;
	
	
	
	public IntLock(int lock) {
		super();
		this.lock = lock;
	}



	@Override
	public void run() {
		try{
			if (lock == 1) {
				lock1.lockInterruptibly();
				try {
					System.out.println("1:lock=1");
					Thread.sleep(500);
					System.out.println("2:lock=1");
				} catch (Exception e) {
					System.out.println("exception:lock=1");
				}
				lock2.lockInterruptibly();
				System.out.println("3:lock=1");
			}else {
				lock2.lockInterruptibly();
				
				try {
					System.out.println("1:lock=2");
					Thread.sleep(500);
					System.out.println("2:lock=2");
				} catch (Exception e) {
					System.out.println("exception:lock=2");
				}
				lock1.lockInterruptibly();
				System.out.println("3:lock=2");
			}
		}catch(Exception e){
			System.out.println("总Exception:lock="+lock);
		}finally {
			if (lock1.isHeldByCurrentThread()) {//在t2中，t1是锁的，但是不是被当前的线程锁的
				System.out.println("finally:lock1="+lock);
				lock1.unlock();
			}
			if (lock2.isHeldByCurrentThread()) {
				System.out.println("finally:lock2="+lock);
				lock2.unlock();
				
			}
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		IntLock r1 = new IntLock(1);
		IntLock r2 = new IntLock(2);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		//处于并发阶段
		t1.start();
		t2.start();
		
		Thread.sleep(1000);
		
		t2.interrupt();
	}
	
	

}
