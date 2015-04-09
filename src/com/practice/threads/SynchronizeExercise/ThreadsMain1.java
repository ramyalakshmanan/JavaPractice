package com.practice.threads.SynchronizeExercise;

public class ThreadsMain1 {

	public static void main(String args[]) {

		Runnable r1 = new PrintNumbers(new Print(), 1, 10);
		Runnable r2 = new PrintNumbers(new Print(), 2, 10);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
