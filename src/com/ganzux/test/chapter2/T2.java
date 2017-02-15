package com.ganzux.test.chapter2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class T2 {

	public static void main (String[] args) {
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		
		numbers.add(3);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(1);
		numbers.add(2);
		numbers.add(4);
		numbers.add(1);

		System.out.println(removeDuplicates(numbers));
		System.out.println(numbers);
		
		numbers.add(3);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(1);
		numbers.add(2);
		numbers.add(4);
		numbers.add(1);

		removeDuplicatesNoMap(numbers);
		
		System.out.println(numbers);
	}
	
	/**
	 * Write code to remove duplicates from an unsorted linked list.
	 * @param numbers
	 * @return
	 */
	public static Map<Integer, Integer> removeDuplicates(LinkedList<Integer> numbers){

		// Approach 1: use a map to store the numbers and convert the map into a list
		// or remove the values from the original list. In fact, if we use a BST
		// we will have the elements sorted
		Map<Integer, Integer> sortedElements = new TreeMap<Integer, Integer>();
		for (Iterator<Integer> iterator = numbers.iterator() ; iterator.hasNext() ; ) {

			Integer n = iterator.next();

			if (sortedElements.get(n) != null){
				iterator.remove();
			}

			sortedElements.put(n, n);
		}

		return sortedElements;
	}
	
	/**
	 * 
	 * @param numbers
	 * @return
	 */
	public static void removeDuplicatesNoMap(LinkedList<Integer> numbers){

		// Approach 2: loop over every single element and again within the rest of
		// the elements. If we find a repeated one, we can remove it
		int positionI = 0;
		Iterator<Integer> iterator0 = numbers.iterator();

		while (iterator0.hasNext()) {

			Integer n0 = iterator0.next();
			positionI ++;
			
			int positionJ = 0;
			for (Iterator<Integer> iterator1 = numbers.iterator() ; iterator1.hasNext() ; ) {
				Integer n1 = iterator1.next();
				positionJ ++;
				
				if(positionI != positionJ && n0 == n1){
					iterator1.remove();
				}
				
			}
			
			iterator0 = numbers.subList(positionI, numbers.size()).iterator();
		}

	}
	
	/**
	 * Implement an algorithm to find the kth to last element of a singly linked list
	 */
	public static void findKthToLast(LinkedList<Integer> numbers){
		
	}

}
