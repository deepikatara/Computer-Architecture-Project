package com.mitchellf.stmNumberOne;

import java.util.LinkedList;

import org.multiverse.api.references.TxnInteger;

public class ReadHeavyTest {
	
	public static void main(String[] args) {
		
		// Create linked list
		LinkedList<LLNodeImmutable> immutableList = new LinkedList<LLNodeImmutable>();
		
		//Initialize values
		for (int i = 0; i < 1000; i++) {			
			immutableList.add(new LLNodeImmutable(i));	
		}
		
		long sum = 0;
		
		//Run 10 iterations and take the average time
		for (int k = 0; k < 10; k++) {
		
			// record start time
			long startTime = System.nanoTime();
			
			// iterate through list 100000 times and access values
			for (int i = 0; i < 100000; i++) {
				for (int j = 0; j < 1000; j++) {
					int a = immutableList.get(j).value;
				}
			}
					
			// calculate end time
			long endTime = System.nanoTime();
			
			long elapsedTime = endTime - startTime;
			
			sum = sum + elapsedTime;
		}
		
		long average = sum/10;
			
		// log elapsed time
		System.out.println("Average time (ns) for 100000 iterations using \"immutable\" methodology: " + average);
		
		// Create linked list
		LinkedList<LLNode> list = new LinkedList<LLNode>();

		//Initialize values
		for (int i = 0; i < 1000; i++) {			
			list.add(new LLNode(i));	
		}

		long sum2 = 0;

		//Run 10 iterations and take the average time
		for (int k = 0; k < 10; k++) {

			// record start time
			long startTime = System.nanoTime();

			// iterate through list 100000 times and access values
			for (int i = 0; i < 100000; i++) {
				for (int j = 0; j < 1000; j++) {
					Integer a = list.get(j).getValue();
				}
			}

			// calculate end time
			long endTime = System.nanoTime();

			long elapsedTime = endTime - startTime;

			sum2 = sum2 + elapsedTime;
		}		
		
		long average2 = sum2/10;
				
		System.out.println("Average time (ns) for 100000 iterations without access permission methodology: " + average2);	
		
		System.out.println("Speed fraction : " + (double)average/(double)average2);
		
	}

}
