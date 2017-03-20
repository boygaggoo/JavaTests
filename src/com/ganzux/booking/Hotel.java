package com.ganzux.booking;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
– The words to be find will always be singe words line ‘breakfast’ or ‘noise’. Never double words like
‘swimming pool’.
– Hotel ud is a 4-byte integer.
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

	 public static void main(String args[] ) throws Exception {
		 
		 Map<String, String> keys = new HashMap<String, String>();
		 String[] keyWords = args[0].split(" ");
		 
		 Map<Integer, Integer> reviewHotels = new TreeMap<Integer, Integer>();
		 
		 for (String key : keyWords){
			 keys.put(key, key);
		 }
		 
		 int reviews = Integer.valueOf(args[1]);
		 int position = 2;
		 
		 for (int i = 0 ; i < reviews ; i++){
			 int idHotel = Integer.valueOf(args[position]);
			 position++;
			 String text = args[position];
			 position++;
			 
			 for (String word : text.split(" ")){
				 if (keys.containsKey(word)){
					 Integer score = reviewHotels.get(idHotel);
					 if (score == null){
						 score = 0;
					 }
					 score ++;
					 reviewHotels.put(idHotel, score);
				 }
			 }
		 }
		 
		 Map<Integer, Integer> sortedIds = sortByValue(reviewHotels);
	}
	 
	 public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map ) {
	    List<Map.Entry<K, V>> list = new LinkedList<>( map.entrySet() );
	    Collections.sort( list, new Comparator<Map.Entry<K, V>>()
	    {
	        @Override
	        public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
	        {
	            return ( o1.getValue() ).compareTo( o2.getValue() );
	        }
	    } );

	    Map<K, V> result = new LinkedHashMap<>();
	    for (Map.Entry<K, V> entry : list) {
	        result.put( entry.getKey(), entry.getValue() );
	    }
	    return result;
	}
	 
}
