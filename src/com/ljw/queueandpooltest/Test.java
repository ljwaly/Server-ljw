package com.ljw.queueandpooltest;

public class Test {
	public static void main(String[] args) {
		MyWork myWork = new MyWork();
		ManagerQueue mq = new ManagerQueue(myWork);
		mq.init();
		
		mq.addMessage("j15");
		mq.addMessage("j16");
		mq.addMessage("j17");
		mq.addMessage("j18");
		mq.addMessage("j19");
		mq.addMessage("j20");
		mq.addMessage("j21");
	}
}
