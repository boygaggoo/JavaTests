package com.ganzux.zendesk;

import java.util.ArrayList;
import java.util.List;

class Session1 {
	public static void main(String[] args) {

		// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
		System.out.println(divisible(1, 10));

		int divisorMax = 30;
		List<Integer> p = generatePrimes(divisorMax);
		int result = 1;
		 
		for (int i = 0; i < p.size(); i++) {
		int a = (int) Math.floor(Math.log(divisorMax) / Math.log(p.get(i)));
		    result = result * ((int)Math.pow(p.get(i), a));
		}
		System.out.println(result);
		
		// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
		System.out.println(divisible(1, 30));

	}

	private static double divisible(int from, int to){

		double returnedNumber = 1;

		while (true){

			boolean divisible = true;

			forloop:
				for (int i = from ; i <= to ; i++){

					if (returnedNumber % i != 0){
						divisible = false;
						break forloop;
					}

				}

			if (divisible){
				return returnedNumber;
			}

			returnedNumber++;

		}
	}






	private static List<Integer> generatePrimes(int upperLimit){
		List<Integer> primes = new ArrayList<Integer>();
		boolean isPrime;
		int j;

		primes.add(2);

		for (int i = 3; i <= upperLimit; i += 2) {
			j = 0;
			isPrime = true;
			while (primes.get(j) * primes.get(j) <= i) {
				if (i % primes.get(j) == 0) {
					isPrime = false;
					break;
				}
				j++;
			}
			if (isPrime) {
				primes.add(i);
			}
		}

		return primes;
	}
}
