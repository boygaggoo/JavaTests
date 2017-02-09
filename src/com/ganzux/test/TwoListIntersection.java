package com.ganzux.test;

public class TwoListIntersection {

	public static int getIntersectionNode(int[] arrayA, int[] arrayB) {

		int aSize = arrayA.length;
		int bSize = arrayB.length;
		
		// we need the diff to skip those positions from the biggest array
		int diff = (aSize > bSize ? aSize - bSize : bSize - aSize);

		// position in arrayA where we have the first common occurrence
		int positionIntersectionInA = -1;

		int pointerA = 0;
		int pointerB = 0;

		if (aSize > bSize){
			pointerA = diff;
			pointerB = 0;
		} else {
			pointerA = 0;
			pointerB = diff;
		}

		boolean matched = false;

		while (pointerB < bSize){
			int numberA = arrayA[pointerA];
			int numberB = arrayB[pointerB];
			
			if (numberA != numberB){
				positionIntersectionInA = -1;
				matched = false;
			} else if( !matched ){
				positionIntersectionInA = pointerA;
				matched = true;
			}

			pointerB++;
			pointerA++;
		}
		
		return positionIntersectionInA;

    }
	
	public static void main(String[] args){
		
		int[] l1 = new int[]{10,5,8,9,4,9,7,3,2,5};
		int[] l2 = new int[]{   5,8,9,4,9,4,3,2,5};
		int[] l3 = new int[]{ 5,8,9,4,9,4,3,2,5,9};

		System.out.println("Position (0 based) in first array for intersection: " + getIntersectionNode(l1, l2));
		System.out.println("Position (0 based) in first array for intersection: " + getIntersectionNode(l2, l1));
		System.out.println("Position (0 based) in first array for intersection: " + getIntersectionNode(l1, l1));
		System.out.println("Position (0 based) in first array for intersection: " + getIntersectionNode(l2, l2));
		System.out.println("Position (0 based) in first array for intersection: " + getIntersectionNode(l1, l3));
	}
}
