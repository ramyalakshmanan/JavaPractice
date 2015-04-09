package com.practice.threads.synchronizeExercise;

public class Print {

	private boolean isEven = false;

	public synchronized void print(int number) {
		if(number %2 == 0){
			while (!isEven) {
				try {
					wait();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			System.out.println("Even" + number);
			isEven = false;
			notifyAll();
		}else{
			while (isEven) {
				try {
					wait();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			System.out.println("Odd" + number);
			isEven = true;
			notifyAll();
		}
		
	}

	public synchronized void printOdd(int number) {
		while (isEven) {
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		System.out.println("Odd" + number);
		isEven = true;
		notifyAll();
	}
	
	public synchronized void printEven(int number) {
		while (!isEven) {
			try {
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		System.out.println("Even" + number);
		isEven = false;
		notifyAll();
	}
}
