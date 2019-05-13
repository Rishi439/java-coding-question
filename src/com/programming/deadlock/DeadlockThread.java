package com.programming.deadlock;

public class DeadlockThread implements Runnable {

	private Object obj;

	private int i;

	private String threadName;

	public DeadlockThread(Object obj, int i, String threadName) {
		super();
		this.obj = obj;
		this.i = i;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		synchronized (obj) {
			System.out.println("Thread Name : " + threadName);
			for (int i = 0; i < 100; i++) {
				this.i++;
			}
		}
	}

}
