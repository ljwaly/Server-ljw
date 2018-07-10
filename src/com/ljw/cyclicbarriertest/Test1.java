package com.ljw.cyclicbarriertest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * 常规测试线程等候
 * 
 * 只有new CyclicBarrier(2)线程数达到2，所有的线程才会唤醒，往下执行，不然会一直等待
 * 
 * 结果：1 2   或者  2 1
 * 
 * @author ljw
 *
 */
public class Test1 {

	static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

	
	public static void main(String[] args) {
		
		new Thread(){
			public void run() {
				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					System.out.println(1);
				}
			};
		}.start();
		
		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			System.out.println(2);
		}
		
		
	}
}
