package com.ganzux.booking;

import java.util.Scanner;

/*
 * Problem
Given a list of numbers, e.g.:
25626 25757 24367 24267 16 100 2 7277
Output a delta encoding for the sequence. In a delta encoding, the first element is reproduced as is.
Each subsequent element is represented as the numeric difference from the element before it. E.g.
for the sequence above, the delta encoding would be:
25626 131 -1390 -100 -24251 84 -98 7275
However, if a difference value does not fit in a single signed byte, i.e. -127 <= x <= 127, then,
instead of the difference, we would like to use an escape token, printing it.
This will denote that the value following the escape token is a full four-byte difference value,
rather than a one-byte different value.
For this exercise, we'll declare -128 as the escape token.
Following the same example above, the final result would be:
25626 -128 131 -128 -1390 -100 -128 -24251 84 -98 -128 7275
 */

public class Delta {
	
public static void main(String args[] ) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		String myString = scanner.nextLine();
		scanner.close();

		delta(myString);
	}


	public static void delta(String input) throws Exception {

		StringBuilder sb = new StringBuilder();
		
		Integer lastNumber = null;
		Integer escape = -128;
		
		for (String number : input.split(" ")){
			
			Integer thisNumber = Integer.valueOf(number);
			
			if (lastNumber == null){
				sb.append(number).append(" ");
			}
			
			else {
				Integer diff =  thisNumber - lastNumber;
				if (diff <= -127 || diff >= 127){
					sb.append(escape).append(" ");
				}
				sb.append(diff).append(" ");
			}
			
			lastNumber = thisNumber;
		}
		
		System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
		
	}
}
