package com.practice.threads.SynchronizeExercise;

public class PrintNumbers implements Runnable{

	private int MAX;
	private int current;
	private Print print;
	
	public PrintNumbers(Print print,int start, int max){
		this.MAX = max;
		this.current = start;
		this.print = print;
	}
	
	public void run (){		
		while(current <= MAX){
			if(current%2 == 0){
				print.printEven(current);
			}else{
				print.printOdd(current);
			}
			//print.print(current);
			current+=1;
		}
	}	
}
