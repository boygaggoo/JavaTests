package com.ganzux.test;

public class SQRT {

	public static double sqrt(int number) {
		double t;
	 
		double squareRoot = number / 2;
	 
		if (squareRoot > 0){
			do {
				t = squareRoot;
				squareRoot = (t + (number / t)) / 2;
			} while ((t - squareRoot) != 0 && t > 0);
		} else {
			squareRoot = number;
		}

		return squareRoot;
	}
	
	public static void main(String[] argd){
		System.out.println(sqrt(4));
		System.out.println(sqrt(9));
		System.out.println(sqrt(16));
		System.out.println(sqrt(100));
		
		System.out.println(sqrt(24574776));
		System.out.println(sqrt(1));
		System.out.println(sqrt(0));
	}
}
