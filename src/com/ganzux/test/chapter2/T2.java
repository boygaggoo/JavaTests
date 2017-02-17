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
		
		partition(numbers, 3);
		
		int[] sum = sumReverse(new int[]{7, 1, 6}, new int[]{5, 9, 2});
		System.out.println("\r\n\r\n");
		for (int i : sum){
			System.out.print(i + " ");	// 617 + 295 = 2, 1, 9 = 912
		}
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
	public static List<Integer> findKthToLast(LinkedList<Integer> numbers, int position){
		List<Integer> exit = new LinkedList<Integer>();

		for (int i = position ; i < numbers.size() ; i++){
			exit.add(numbers.get(i));
		}

		return exit;
	}
	
	/**
	 * Implement an algorithm to delete a node in the middle of a singly linked list,
	 * given only access to that node.
	 * EXAMPLE
	 * Input: the node c from the linked list a->b->c->d->e
	 * Result: nothing is returned, but the new linked list looks like a- >b- >d->e
	 */
	public static void removeElement(LinkedList<Integer> numbers, int number){
		Integer n = null;
		for (Iterator<Integer> iterator = numbers.iterator() ; iterator.hasNext() ;) {
			n = iterator.next();
			if (n == number){
				iterator.remove();
			}
		}
	}
	

	/**
	 * Write code to partition a linked list around a value x, such that all nodes less than
	 * x come before all nodes greater than or equal to x.
	 */
	public static void partition(LinkedList<Integer> numbers, int number){
		// The better approach for this would be create a Java TreeMap, putting the number at
		// the first time, so it will be the root and inserting the rest of the numbers:
		Map<Integer, Integer> myTree = new TreeMap<Integer, Integer>();
		myTree.put(number, number);

		Integer n = null;
		for (Iterator<Integer> iterator = numbers.iterator() ; iterator.hasNext() ;) {
			n = iterator.next();
			myTree.put(n, n);
		}
		
		for(Map.Entry<Integer, Integer> entry : myTree.entrySet()) {
			Integer key = entry.getKey();
			
			if (key == number){
				System.out.println("\r\n-->" + key + "<--");
			} else {			
				System.out.print(key + ", ");
			}
		}

	}
	
	
	
	/**
	 * You have two numbers represented by a linked list, where each node contains a
	 * single digit. The digits are stored in reverse order, such that the Ts digit is at the
	 * head of the list. Write a function that adds the two numbers and returns the sum
	 * as a linked list.
	 * EXAMPLE
	 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
	 * Output: 2 -> 1 -> 9.That is, 912.
	 * FOLLOW UP
	 * Suppose the digits are stored in forward order. Repeat the above problem.
	 * EXAMPLE
	 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
	 * Output: 9 -> 1 -> 2.That is, 912.
	 */
	public static int[] sumReverse(int[] a, int[] b){
		int maxSize = a.length > b.length ? a.length : b.length;

		int[] sum = new int[maxSize + 1];
		// normalize arrays, put 0 at the end
		a = resizeArray(a, b.length, 0, false);
		b = resizeArray(b, a.length, 0, false);

		int rest = 0;
		for (int i = 0 ; i < maxSize ; i++){
			
			int partialSum = rest;
			partialSum += a[i] + b[i];

			rest = partialSum / 10;
			
			// no rest
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
		
		partition(numbers, 3);
		
		int[] sum = sumReverse(new int[]{7, 1, 6}, new int[]{5, 9, 2});
		System.out.println("\r\n\r\n");
		for (int i : sum){
			System.out.print(i + " ");	// 617 + 295 = 2, 1, 9 = 912
		}
		
		sum = sum(new int[]{6, 1, 7}, new int[]{2, 9, 5});
		System.out.println("\r\n\r\n");
		for (int i : sum){
			System.out.print(i + " ");	// 617 + 295 = 9, 1, 2
		}
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
	public static List<Integer> findKthToLast(LinkedList<Integer> numbers, int position){
		List<Integer> exit = new LinkedList<Integer>();

		for (int i = position ; i < numbers.size() ; i++){
			exit.add(numbers.get(i));
		}

		return exit;
	}
	
	/**
	 * Implement an algorithm to delete a node in the middle of a singly linked list,
	 * given only access to that node.
	 * EXAMPLE
	 * Input: the node c from the linked list a->b->c->d->e
	 * Result: nothing is returned, but the new linked list looks like a- >b- >d->e
	 */
	public static void removeElement(LinkedList<Integer> numbers, int number){
		Integer n = null;
		for (Iterator<Integer> iterator = numbers.iterator() ; iterator.hasNext() ;) {
			n = iterator.next();
			if (n == number){
				iterator.remove();
			}
		}
	}
	

	/**
	 * Write code to partition a linked list around a value x, such that all nodes less than
	 * x come before all nodes greater than or equal to x.
	 */
	public static void partition(LinkedList<Integer> numbers, int number){
		// The better approach for this would be create a Java TreeMap, putting the number at
		// the first time, so it will be the root and inserting the rest of the numbers:
		Map<Integer, Integer> myTree = new TreeMap<Integer, Integer>();
		myTree.put(number, number);

		Integer n = null;
		for (Iterator<Integer> iterator = numbers.iterator() ; iterator.hasNext() ;) {
			n = iterator.next();
			myTree.put(n, n);
		}
		
		for(Map.Entry<Integer, Integer> entry : myTree.entrySet()) {
			Integer key = entry.getKey();
			
			if (key == number){
				System.out.println("\r\n-->" + key + "<--");
			} else {			
				System.out.print(key + ", ");
			}
		}

	}
	
	
	
	/**
	 * You have two numbers represented by a linked list, where each node contains a
	 * single digit. The digits are stored in reverse order, such that the Ts digit is at the
	 * head of the list. Write a function that adds the two numbers and returns the sum
	 * as a linked list.
	 * EXAMPLE
	 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
	 * Output: 2 -> 1 -> 9.That is, 912.
	 * FOLLOW UP
	 * Suppose the digits are stored in forward order. Repeat the above problem.
	 * EXAMPLE
	 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
	 * Output: 9 -> 1 -> 2.That is, 912.
	 */
	public static int[] sumReverse(int[] a, int[] b){
		int maxSize = a.length > b.length ? a.length : b.length;

		int[] sum = new int[maxSize + 1];
		// normalize arrays, put 0 at the end
		a = resizeArray(a, b.length, 0, false);
		b = resizeArray(b, a.length, 0, false);

		int rest = 0;
		for (int i = 0 ; i < maxSize ; i++){
			
			int partialSum = rest;
			partialSum += a[i] + b[i];

			rest = partialSum / 10;
			
			// no rest
			if (rest == 0){
				sum[i] = partialSum;
			} else {
				sum[i] = partialSum - 10;  // = partialSum % 10
			}
		}
		
		// If there is one last value, we add it at the end; if not, we remove the last zero
		if (rest > 0){
			sum[sum.length - 1] = rest;
		} else {
			sum = resizeArray(sum, sum.length - 1, 0, false);
		}

		return sum;
	}
	
	/**
	 * You have two numbers represented by a linked list, where each node contains a
	 * single digit. The digits are stored in reverse order, such that the Ts digit is at the
	 * head of the list. Write a function that adds the two numbers and returns the sum
	 * as a linked list.
	 * EXAMPLE
	 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
	 * Output: 2 -> 1 -> 9.That is, 912.
	 * FOLLOW UP
	 * Suppose the digits are stored in forward order. Repeat the above problem.
	 * EXAMPLE
	 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
	 * Output: 9 -> 1 -> 2.That is, 912.
	 */
	public static int[] sum(int[] a, int[] b){
		int maxSize = a.length > b.length ? a.length : b.length;

		int[] sum = new int[maxSize + 1];
		// normalize arrays, put 0 at the end
		a = resizeArray(a, b.length, 0, true);
		b = resizeArray(b, a.length, 0, true);

		int rest = 0;
		for (int i = maxSize - 1 ; i >= 0 ; i--){
			
			int partialSum = rest;
			partialSum += a[i] + b[i];

			rest = partialSum / 10;
			
			// no rest
			if (rest == 0){
				sum[i + 1] = partialSum;
			} else {
				sum[i + 1] = partialSum - 10;  // = partialSum % 10
			}
		}
		
		// If there is one last value, we add it at the end; if not, we remove the last zero
		if (rest > 0){
			sum[0] = rest;
		} else {
			sum = resizeArray(sum, sum.length - 1, 0, true);
		}

		return sum;
	}
	
	private static int[] resizeArray(int[] array, int newSize, int value, boolean init){

		int newValues = newSize - array.length;
		// It is necessary to resize, adding items
		if (newValues > 0){

			int[] newArray = new int[newSize];

			for (int i = 0 ; i < newSize ; i++){

				// fill in the beginning 
				if (init && i < newValues){
					newArray[i] = value;
				} else if (!init && i > newValues){
					newArray[i] = value;
				} else {
					newArray[i] = array[i];
				}
			}
	
			return newArray;
		}
		
		// It is necessary to resize, removing items
		else if (newValues < 0){
			int[] newArray = new int[newSize];
			// removing at the end
			if (!init){
				for (int i = 0 ; i < newSize ; i++){
					newArray[i] = array[i];
				}
			}
			
			// removing at the beginning
			else {
				int removeElements = newValues * -1;
				for (int i = removeElements ; i <= newSize ; i++){ 
					newArray[i - removeElements] = array[i];
				}
			}
			return newArray;
		}

		// same size
		else {
			return array;
		}
	}
}

