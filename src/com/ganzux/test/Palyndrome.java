package com.ganzux.test;

import java.util.HashMap;
import java.util.Map;

public class Palyndrome {

	public static boolean isScrambledPalyndrome(String word){

		Map<Character, Boolean> charMap = new HashMap<Character, Boolean>();
		int i = 0;

		int length = word.length();
		boolean isEven = word.length() % 2 == 0;

		while(i < length){
			
			char c = word.charAt(i);

			if (charMap.containsKey(c)){
				charMap.remove(c);
			} else {
				charMap.put(c, true);
			}

			i++;
		}
		
		if (isEven && charMap.isEmpty()){
			return true;
		}

		// uneven, we must have 1 value
		if (!isEven && charMap.size() == 1){
			return true;
		}
		
		return false;
	}
		
		
	public static boolean isPalyndrome(String word){
		boolean palyndrome = true;
		
		int i = 0;

		int length = word.length();
		int halfLength = length / 2;
		boolean isEven = word.length() % 2 == 0;

		char[] lifo = new char[halfLength];

		while(i < length){

			boolean isCentralChar = !isEven && i == halfLength;

			// we put the values in the LIFO Stack
			if (i < halfLength){
				lifo[i] = word.charAt(i);
			}

			// we skip the central character
			if (i >= halfLength && !isCentralChar){
				int lifoPosition = length - i - 1;
				if (lifo[lifoPosition] != word.charAt(i)){
					return false;
				}
			}

			i++;
		}
		
		return palyndrome;
	}
	
	public static void main(String[] args){
		System.out.println(isPalyndrome("rotor"));
		System.out.println(isPalyndrome("caac"));
		System.out.println(isPalyndrome("tu"));
		System.out.println(isPalyndrome("oso"));
		
		
		System.out.println(isScrambledPalyndrome("rotor"));
		System.out.println(isScrambledPalyndrome("caac"));
		System.out.println(isScrambledPalyndrome("tu"));
		System.out.println(isScrambledPalyndrome("oso"));
		
		System.out.println(isScrambledPalyndrome("rotor"));
		System.out.println(isScrambledPalyndrome("toror"));
		System.out.println(isScrambledPalyndrome("racecar"));
		
		System.out.println(isScrambledPalyndrome("poccaawponyny"));
		System.out.println(isScrambledPalyndrome("poccaaxwponyny"));
	}
}
