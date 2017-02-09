package com.ganzux.test;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	public static void main(String[] args){
		System.out.println( getSequence(10) );
	}
	
	public static List<Integer> getSequence(int limit){
		
		List<Integer> sequence = new ArrayList<Integer>();
		
		for (int i = 0 ; i < limit ; i++){
			if (i < 2) {
				sequence.add(1);
			} else {
				sequence.add(sequence.get(i - 1) + sequence.get(i - 2));
			}
		}
		
		return sequence;
	}
}
