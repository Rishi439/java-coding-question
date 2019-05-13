package com.programming.deadlock;

public class Deadlock {

	public static void main(String[] args) {

		int i = 0;
		Object obj = new Object();
		DeadlockThread deadLock1 = new DeadlockThread(obj, i, "Thread 1");
		DeadlockThread deadLock2 = new DeadlockThread(obj, i, "Thread 2");

		Thread thread1 = new Thread(deadLock1);
		Thread thread2 = new Thread(deadLock2);
		thread1.start();
		thread2.start();

	}
}
