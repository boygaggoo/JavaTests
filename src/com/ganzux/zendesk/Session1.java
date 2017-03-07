package com.ganzux.zendesk;


class Session1 {
	public static void main(String[] args) {

		// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
		System.out.println(divisible(1, 10));

		// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
		System.out.println(divisible(1, 20));

	}

	private static int divisible(int from, int to){

		int returnedNumber = 1;

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
}
