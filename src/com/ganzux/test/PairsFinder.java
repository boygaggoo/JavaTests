package com.ganzux.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PairsFinder {

	// Output all pairs in an array that sum up to a certain value v.
	// Output: (i, j), (k, l), ...
	// For example, for an array = [2, 1, 3, 7, 1] and a desired sum v = 4.
	// Output should be: (1,3)

	// numbers as null
	// numbers as an empty list
	// numbers 1 element
	// numbers more than 1
	// negative and positive and 0 (also with sum)
	// array = [Integer.MIN] desired sum = Integer.MAX-2 => Overflow

	public static Set<int[]>umUpTo(List<Integer> numbers, int sum){

	    Map<Integer, Object> possibleSolutions = new HashMap<Integer, Object>();
	    
	    Set<int[]> solutions = new HashSet<int[]>();

	    for (int i = 0 ; i < numbers.size() ; i++){ 
	        int thisNumber = numbers.get(i); // thisNumber = 1

	        if (thisNumber < sum){

	            int subtraction = sum - thisNumber; // Integer.MAX - Integer.MIN
	            if (subtraction + thisNumber == sum)
	            
	            // We have the desire value, so its a solution
	            if (possibleSolutions.get(thisNumber) != null && !(possibleSolutions.get(thisNumber) instanceof String)){
	                possibleSolutions.put(thisNumber, subtraction);
	                solutions.add(new int[]{thisNumber, subtraction});
	                // possibleSolutions = [(2,EMPTY), (3,EMPTY), (3,1)]
	            }
	            
	            else { 
	                possibleSolutions.put(new Integer(subtraction), "EMPTY"); 
	                // possibleSolutions = [(2,EMPTY), (3,EMPTY)]
	            }

	        }
	        
	    }

	    return solutions ;
	}




public static List<int[]> sumUpTo(List<Integer> numbers, int sum){

    List<int[]>  pairs = new ArrayList<int[]>();

    for (int i = 0 ; i < numbers.size() ; i++){
        for (int j = i + 1 ; j < numbers.size() ; j++){
            int firstNumber = numbers.get(i);
            int secondNumber = numbers.get(j);
            
            if ((firstNumber + secondNumber) == sum){
                pairs.add(new int[]{firstNumber, secondNumber});
            }
        }
    }

    return pairs;
}
}
