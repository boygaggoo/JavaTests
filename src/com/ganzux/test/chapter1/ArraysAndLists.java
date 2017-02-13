package com.ganzux.test.chapter1;

import java.util.HashMap;
import java.util.Map;

public class ArraysAndLists {

	/**
	 * Implement an algorithm to determine if a string has all unique characters. What
	 * if you cannot use additional data structures?
	 */
	public static boolean uniqueCharsWithStructure(String data) {
		boolean unique = true;

		Map<Character, Object> charMap = new HashMap<Character, Object>();
		
		for(char c : data.toCharArray()){
			if (charMap.containsKey(c)){
				return false;
			} else {
				charMap.put(c, c);
			}
		}
		
		return unique;
	}
	
	/**
	 * Implement an algorithm to determine if a string has all unique characters. What
	 * if you cannot use additional data structures?
	 */
	public static boolean uniqueCharsWithoutStructure(String data) {
		boolean unique = true;

		for(int i = 0 ; i < data.length() ; i++){
			char c = data.charAt(i);
			
			for(int j = i + 1 ; j < data.length() ; j++){
				char comp = data.charAt(j);
				
				if(c == comp){
					return false;
				}
			}
		}
		
		return unique;
	}
	
	/*
	 * Implement a function void reverse(char* str) in C or C++ which reverses a null terminated string.
	 */
	public static void reverse(char[] str){
		char empty;
		
		final int size = str.length;
		
		for (int i = 0 ; i < size / 2 ; i++){
			empty = str[size - i - 1];
			str[size - i - 1] = str[i];
			str[i] = empty;
		}
		
	}
	
	/* Given two strings, write a method to decide if one is a permutation of the other.
	 * 
	 */
	public static boolean isPermutation(String one, String two){
		Map<Character, Integer> letters = new HashMap<Character, Integer>();

		for (char c : one.toCharArray()){
			
			Integer times = letters.get(c);
			if (times == null){
				times = 1;
			} else {
				times ++;
			}
			letters.put(c, times);
		}
		
		for (char c : two.toCharArray()){
			Integer times = letters.get(c);
			
			// New letter in the second word
			if (times == null){
				return false;
			}
			
			// last letter in the second word
			else if (times == 1){
				letters.remove(c);
			}

			// match letter in the second word
			else {
				times --;
			}
		}

		return letters.isEmpty();
	}
	
	/* 
	 * Write a method to replace all spaces in a string with'%20'. You may assume that
	 * the string has sufficient space at the end of the string to hold the additional
	 * characters, and that you are given the "true" length of the string. (Note: if implementing
	 * in Java, please use a character array so that you can perform this operation
	 * in place.)
	 * EXAMPLE
	 * Input: "Mr John Smith
	 * Output: "Mr%20Dohn%20Smith"
	 */
	public static char[] replaceText(char wildCard, String replacement, char... text){

		final int sizeReplacement = replacement.length();

		char[] replaced = new char[text.length];

		for (int i = 0,j = 0 ; i < text.length ; i++, j++){

			// if there is a match, 
			if (text[i] == wildCard){
				// reserve space for the new word
				char[] newArray = new char[replaced.length + sizeReplacement - 1]; // -1 because we decrease the wildcard size
				
				// copy the previous part of the array in the new one
				int k = 0;
				for (; k < j ; k++){
					newArray[k] = replaced[k];
				}

				// now we put the new value
				for (int l = 0; l < sizeReplacement ; k++, l++){
					newArray[k] = replacement.charAt(l);
				}

				j += sizeReplacement - 1;
				replaced = newArray;
			} else {
				replaced[j] = text[i];
			}
		}
		
		return replaced;
	}
	
	/*
	 * Implement a method to perform basic string compression using the counts of 
	 * repeated characters. For example, the string aabcccccaaa would become a2blc5a3. 
	 * If the "compressed" string would not become smaller than the original string, 
	 * your method should return the original string
	 */
	public static String compress(String text){
		StringBuilder sb = new StringBuilder();

		char lastReaded = text.charAt(0);
		int times = 1;
		
		for (int i = 1 ; i < text.length() ; i++){
			char c = text.charAt(i);
			if (lastReaded == c){
				times++;
			} else {
				sb.append(lastReaded).append(times + "");
				times = 1;
				lastReaded = c;
			}
		}
		sb.append(lastReaded).append(times + "");

		return text.length()<sb.length() ? text : sb.toString();
	}
	
	/*
	 * Write an algorithm such that if an element in an MxN matrix is 0,
	 * its entire row and column are set to 0. 
	 */
	private static int[][] zeroMatrix(int[][] matrix){

		// We need to return a new matrix because if we find a zero
		// by recursion all the matrix would be zero!
		int[][] returnMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0 ; i < matrix.length ; i++){
			for (int j = 0 ; j < matrix[i].length ; j++){
				returnMatrix[i][j] = -1;
			}
		}
		
		// looping over the matrix
		for (int i = 0 ; i < matrix.length ; i++){
			for (int j = 0 ; j < matrix[i].length ; j++){

				if (matrix[i][j] == 0) {

					for (int k = 0 ; k < matrix.length ; k++){
						returnMatrix[i][k] = 0;
					}
					for (int k = 0 ; k < matrix[i].length ; k++){
						returnMatrix[k][j] = 0;
					}
				} else if (returnMatrix[i][j] == -1){
					returnMatrix[i][j] = matrix[i][j];
				}
			}
		}
		return returnMatrix;
	}


	public static void main(String[] args){
		System.out.println(uniqueCharsWithStructure("asdfghjklqweeyvb"));
		System.out.println(uniqueCharsWithStructure("asdfghjklqweyvb"));
		
		System.out.println(uniqueCharsWithoutStructure("asdfghjklqweeyvb"));
		System.out.println(uniqueCharsWithoutStructure("asdfghjklqweyvb"));
		
		char[] word = new char[]{'a','b','c','d','e'};
		char[] word2 = new char[]{'a','b','c','d'};
		reverse(word);
		reverse(word2);
		System.out.println(word);
		System.out.println(word2);
		
		System.out.println(isPermutation("abcd", ""));
		System.out.println(isPermutation("", "acv"));
		System.out.println(isPermutation("abcd", "dabc"));
		System.out.println(isPermutation("abcd", "abcda"));
		System.out.println(isPermutation("abcdw", "abcda"));
		System.out.println(isPermutation("abcda", "bcda"));
		
		final String text = "Mr John Smith  ";
		System.out.println(replaceText(' ', "%20", text.toCharArray()));
		
		System.out.println(compress("aabcccccaaa"));
		
		int[][] matrix = new int[6][6];
		matrix[0] = new int[]{1, 2, 3, 4, 5, 6};
		matrix[1] = new int[]{1, 2, 3, 4, 5, 6};
		matrix[2] = new int[]{1, 2, 0, 4, 5, 6};
		matrix[3] = new int[]{1, 2, 3, 4, 5, 6};
		matrix[4] = new int[]{1, 2, 3, 4, 0, 6};
		matrix[5] = new int[]{1, 2, 3, 4, 5, 6};
		
		int[][] zeroMatrix = zeroMatrix(matrix);
		
		for (int i = 0 ; i < zeroMatrix.length ; i++){
			for (int j = 0 ; j < zeroMatrix[i].length ; j++){
				System.out.print(zeroMatrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
