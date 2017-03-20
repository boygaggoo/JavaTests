package com.ganzux.booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Booking {

	/**
	 * Given any number of arrays containing numbers, write a function which
	finds the numbers that appear in exactly two arrays.
	
	arrays = [
	    [6, 2, 2, 0, 4],
	    [5, 0, 2, 6, 7, 1],
	    [6, 7, 9, 9],
	]
	
	find_in_two(arrays) should return [2, 0, 7]  
	 */
	public static void main(String[] args) {
		System.out.println(find_in_two( 2, new int[][] { {6, 2, 2, 0, 4}, {5, 0, 2, 6, 7, 1}, {6, 7, 9, 9} } ));
		
		System.out.println("true " + parentBalanced("asdf((fghjfghjfgj)fghjfgj()fjfgj)"));
		System.out.println("true " + parentBalanced("asdf((fghjfghjfgj)fgh()jfgj()fjfgj)()"));
		System.out.println("false " + parentBalanced("asdf)((fghjfghjfgj)fghjfgj()fjfgj)"));
		System.out.println("false " + parentBalanced("asdf((fghj(fghjfgj)fghjfgj()fjfgj)"));
		
		System.out.println(chainNames(new ArrayList<String>() { {
									    add("Raymond");
									    add("Nora");
									    add("Daniel");
									    add("Louie");
									    add("Peter");
									    add("Esteban");
									} }
		));
	}
	
	private static List<Integer> find_in_two(int numberOfArrays, int[]... arrays){
		List<Integer> exit = new ArrayList<Integer>();

		Map<Integer, Integer> appear = new HashMap<Integer, Integer>();
		Map<Integer, Boolean> alreadyOnTheArray = new HashMap<Integer, Boolean>();
		
		for (int[] array : arrays){

			alreadyOnTheArray = new HashMap<Integer, Boolean>();

			for (int number : array){

				// We find the number in the array
				if (appear.containsKey(number)){
					// The number was not inside this array
					if (alreadyOnTheArray.get(number) == null){
						int times = appear.get(number);
						appear.put(number, times + 1);
						alreadyOnTheArray.put(number, true);
					}

				}
				
				// First occurrence of the number ever
				else {
					appear.put(number, 1);
					alreadyOnTheArray.put(number, true);
				}

			}
		}
		
		for (int number : appear.keySet()){
			int numberInArrays = appear.get(number);
			if (numberOfArrays == numberInArrays){
				exit.add(number);
			}
		}
		
		return exit;
	}

	private static boolean parentBalanced(String str){
		Stack<Character> stack = new Stack<Character>();
		
		for (char c : str.toCharArray()){
			String myChar = String.valueOf(c);
			if ("(".equals(myChar)){
				stack.push('(');
			} else if (")".equals(myChar)){
				if (stack.isEmpty()){
					return false;
				}
				stack.pop();
			}
		}
		
		return stack.isEmpty();
	}
	
	/*
	 * The input is a list of names in random order. We need a function that chains elements of the list
	 * in such a way that the last character of an name is the same as the first one of the next name.

	For instance:
	
	Input: [“Raymond”, “Nora”, “Daniel”, “Louie”, “Peter”, “Esteban”]
	Output: [“Peter”, “Raymond”, “Daniel”, “Louie”, “Esteban”, “Nora”]
	There should be only one solution, so the first element is unique.
	*/
	 private static List<String> chainNames(List<String> names){
		 List<String> chainedNames = new LinkedList<String>();

		 for (String name : names){
			 Map<String, String> map = generateTreeMap(names);

			 while (!map.isEmpty()){
				 String firstLetter = name.substring(0, 1);
				 String lastLetter = name.substring(name.length());
				 String nameContained = map.get(lastLetter);
			 }
			 

			 chainedNames.add(name);

			 
		 }

		 return chainedNames;
	 }
	 
	 // TODO
	 private static Map<String, String> generateTreeMap(List<String> names){
		 Map<String, String> map = new HashMap<String, String>();
		 
		 for (String name : names){
			 String firstLetter = name.substring(0, 1);
			 map.put(firstLetter, name);
		 }
		 
		 return map;
	 }

}
