package com.practice.threads.reentrantLockExercise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsMain2 {

	private final Lock lock = new ReentrantLock();
	private static int max = 10;
	private static int beginIdx = 0;

	public static void main(String args[]) {
		final ThreadsMain2 mainobj = new ThreadsMain2();

		Runnable even = new Runnable() {

			public void run() {
				while (beginIdx <= max) {
					
					if (beginIdx % 2 == 0) {
						System.out.println("even :" +beginIdx);
						mainobj.incrementCounter();
					}
				}
			}
		};

		Runnable odd = new Runnable() {
			public void run() {
				while (beginIdx < max) {
					// System.out.println("odd : " + start);
					if (!(beginIdx % 2 == 0)) {
						System.out.println("odd :" +beginIdx);
						mainobj.incrementCounter();
					}
				}
			}
		};

		Thread t1 = new Thread(odd);
		Thread t2 = new Thread(even);
		t1.start();
		t2.start();
	}

	public void incrementCounter() {
		lock.lock();
		try {
			beginIdx+=1;
		} finally {
			lock.unlock();
		}
	}
}