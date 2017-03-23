package com.ganzux.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Customer Service capacity
At Booking.com our customer service team is an important contributor to customer satisfaction.
During busy times, however, there might be more calls to customer service than the number of
customers service executives can manage. Fortunately, we record data on that. We've collected
information about all phone calls to our call centers for the past year.
Given that our current number of customer care agents is X. Determine how many more people we
would need to hire, to make sure that our customers would not have to wait during peak hours
(i.e. that we don't have more phone calls than we have customer service executives).
Input:
The first line contains the current number of customers service executives X.
The second line contains an integer N, which is the number of data points in the data set.
The next N lines are whitespace-separated pairs of timestamps (a timestamp is an integer that
represents seconds since epoch). On each line, the first time is the time when the call was
started, and the second one is when that call ended.
Output:
A single integer, representing the number of additional customer service executives that we
would need to employ, to cover the call volume during peak times. If the current coverage is
already sufficient, then print 0.
Sample input:
1
3
1481122000 1481122020
1481122000 1481122040
1481122030 1481122035
Sample output:
1
 */
public class CS {


	public static void main(String args[]) throws Exception {

		Scanner scanner = new Scanner(System.in);

		List<String> myArgs = new ArrayList<String>();
		
		int customers = scanner.nextInt();
		int dataPoints = scanner.nextInt();

		myArgs.add(String.valueOf(customers));
		myArgs.add(String.valueOf(dataPoints));

		for (int i = 0 ; i < dataPoints ; ){
			if (scanner.hasNextLine()){
				String read = scanner.nextLine();
				if (!read.isEmpty()){
					myArgs.add(read);
					i++;
				}
			}
		}
		scanner.close();

		solve(myArgs.toArray(new String[myArgs.size()])); //1 3 2000 2020 2000 2040 2030 2035
		//solve("1", "3", "2000 2020", "2000 2040" ,"2030 2035");
	}
		
		

	public static void solve(String... args) throws Exception {

		int persons = Integer.valueOf(args[0]);
		
		int calls = Integer.valueOf(args[1]);
		
		int position = 2;

		for (int i = 0 ; i < calls ; i++){
			String line = args[position];

			Integer from = Integer.valueOf(line.split(" ")[0]);
			Integer to = Integer.valueOf(line.split(" ")[1]);
			
			for (int j = position ; j < args.length ; j++){
				String lineBellow = args[j];

				Integer fromBellow = Integer.valueOf(lineBellow.split(" ")[0]);
				
				if (from < fromBellow && to < fromBellow){
					persons ++;
				}
			}
			
			position ++;
		}
		System.out.println(persons - 1);
	}

}
