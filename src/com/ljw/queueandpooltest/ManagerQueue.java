package com.ljw.queueandpooltest;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ManagerQueue {

	/**
	 * 消息队列
	 */
	public static Queue<String> messageQueue =  new LinkedBlockingDeque<String>(100);
	
	/**
	 * 线程池中的线程数
	 */
	private static final int corePoolSize = 20;
	
	/**
	 * 池中允许的最大线程数
	 */
	private static int maximumPoolSize = 50;
	
	/**
	 * 如果超出线程池线程总数，最大等待时间，超时，可能会丢失？？
	 */
	private static long keepAliveTime = 1;
	
	/**
	 * 时间单位
	 */
	private static TimeUnit unit = TimeUnit.SECONDS;
	/**
	 * 用于在执行任务之前保存任务的队列。这个队列将只保存被execute方法执行提交的异步任务。
	 */
	private static BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
	
	/**
	 * 线程池
	 */
	public static ThreadPoolExecutor pool = 
			new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	
	
	/**
	 * 需要做的任务，实际中可以使用接口或者抽象类
	 */
	private MyWork myWork;
	
	public ManagerQueue(MyWork myWork) {
		this.myWork = myWork;
	}

	/**
	 * 启动线程池方法
	 * 
	 */
	public void init(){
		new Thread("线程池1"){
			public void run() {
				
				while(true){
					long size = messageQueue.size();
					
					if (size == 0) {//如果队列为空
						try {
							Thread.sleep(200);//等待0.2s
						} catch (InterruptedException e) {
						}
					}else{
						
						String message = messageQueue.poll();//取出头部元素
						if (message != null && !"".equals(message)) {
							pool.execute(new Command(message));//执行任务
						}
					}
				}
				
			};
			
		}.start();
	}
	
	class Command implements Runnable{

		private String message;
		
		@Override
		public void run() {
			myWork.shoot(message);//具体任务
		}
		
		public Command(String msg){
			this.message = msg;
		}
		
	}
	
	/**
	 * 往消息队列添加消息
	 * 
	 * @param msg
	 * @return
	 */
	public boolean addMessage(String msg){
		boolean result = messageQueue.offer(msg);
		return result;
	}
	
	/**
	 * 清空消息队列
	 */
	public void clearMessageQueue(){
		messageQueue.clear();
	}
	
	
	
}
