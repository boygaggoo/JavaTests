package com.ganzux.booking;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/*
 * Sort hotel list challenge
Problem statement
Given a set of hotels and its guests reviews, sort the hotels based on a list of words specified by a user.
The criteria to sort the hotels should be how many times the words specified by the user is mentioned in
the hotel reviews.

Input
The first line contains a space-separated set of words which we want to find mentions in the hotel reviews.
The second line contains one integer M, which is the number of reviews.
This is followed by M+M lines, which alternates an hotel ID and a review belonging to that hotel.

Output
A list of hotel IDs sorted, in descending order, by how many mentions they have of the words specified
in the input.

Notes
– The words to be find will always be single words line ‘breakfast’ or ‘noise’. Never double words like
‘swimming pool’.
– Hotel id is a 4-byte integer.
– Words match should be case-insensitive.
– Dots and commas should be ignored.
– If a word appears in a review twice, it should count twice.
– If two hotels have the same number of mentions, they should be sorted in the output based on their ID,
smallest ID first.
– In case one or more test cases time out, consider revisiting the runtime complexity of your algorithms.


Sample input

breakfast beach citycenter location metro view staff price
5
1
This hotel has a nice view of the citycenter. The location is perfect.
2
The breakfast is ok. Regarding the location, it is quite far from citycenter but price is cheap so it is worth.
1
Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
1
They said I could't take my dog and there were other guests with dogs! That is not fair!
2
Very friendly staff and goof cost-benefit ratio. Its location is a bit far from citycenter.

2 1


Explanation

Hotel 2 has 7 mentions of the words: ‘location’ and ‘citycenter’ are mentioned twice while ‘breakfast’,
‘price’ and ‘staff’ are mentioned once. Hotel 1 in the other hand has 6 mentions in total ‘location’
and ‘citycenter’ also twice and then ‘view’ and ‘metro’ once.
 */


public class Hotel {

	public static void main(String args[]) throws Exception {

		Scanner scanner = new Scanner(System.in);

		// keyWords
		String readedKeyWords = scanner.nextLine();

		// number of reviews
		int reviews = scanner.nextInt();

		// map with all the values
		Map<String, String> keys = new HashMap<String, String>();
		String[] keyWords = readedKeyWords.split(" ");
		 
		Map<Integer, Integer> reviewHotels = new TreeMap<Integer, Integer>();
		 
		for (String key : keyWords){
			keys.put(key.toLowerCase(), key);
		}

		// read opinions 
		for (int i = 0 ; i < reviews ; ){
			if (scanner.hasNextLine()){
				String read = scanner.nextLine();
				if (!read.isEmpty()){
					int idHotel = Integer.valueOf(read);
					
					if (scanner.hasNextLine()){
						read = scanner.nextLine();
						if (!read.isEmpty()){

							for (String word : read.split(" ")){

								String lookingWord = word.replaceAll("\\.", "").replaceAll(",", "").toLowerCase();

								 if (keys.containsKey(lookingWord)){
									 Integer score = reviewHotels.get(idHotel);
									 if (score == null){
										 score = 0;
									 }
									 score ++;
									 reviewHotels.put(idHotel, score);
								 }

							 }

							i++;
						}
					}
					
				}
			}
	
		}

		scanner.close();
		 
		Map<Integer, Integer> sortedMap = sortByValue(reviewHotels);
		
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
			sb.append(entry.getKey()).append(" ");
        }
		
		System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
	}
	 
	 public static Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
		// 1. Convert Map to List of Map
		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		// Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
		    public int compare(Map.Entry<Integer, Integer> o1,
		                       Map.Entry<Integer, Integer> o2) {
		        return (o2.getValue()).compareTo(o1.getValue());
		    }
		});

		// 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
	}
	 
}
