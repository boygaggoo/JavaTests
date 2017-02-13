package com.ganzux.test.chapter1;

import java.util.ArrayList;
import java.util.List;

public class StringsUtilities {

	/**
	 * Design an algorithm to print all permutations of a string. For simplicity, assume all
	 * characters are unique
	 */
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    
	    // no prefix, we print the word
	    if (n == 0){
	    	System.out.println(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++){
	        	// Split the chain in 2: * prefix + position i
	        	//						 * rest of the chain except position i
	        	final String newPrefix = prefix + str.charAt(i);
	        	final String restStr   = str.substring(0, i) + str.substring(i + 1, n);
	            permutation(newPrefix, restStr);
	        }
	    }
	}
	
	public static void main(String[] args){
		permutation("abcd");
	}

}
