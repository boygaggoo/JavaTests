package com.ganzux.test;

public class Math {

	public static float squareRoot(int x, int ep){
		
		float l = 0;
		float r = 0;
		
		float est = (r - l) / 2;

		float last = 0;
		
		while (est - last > ep){
			last = est;
			
			float square = est * est;
			
			if (square > x){
				est = l + ((est - l) / 2);
				r = est;
			} else {
				est = r + ((r - est) / 2);
				l = est;
			}
			
		}
		
		return x;
	}
	
	public static double sqrt(int number) {
		double t;
	 
		double squareRoot = number / 2;
	 
		do {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
		} while ((t - squareRoot) != 0);
	 
		return squareRoot;
	}
	
	public static void main(String[] args){
		System.out.println(squareRoot(8, 3));
		
		System.out.println(sqrt(16));
	}
	
		
}
