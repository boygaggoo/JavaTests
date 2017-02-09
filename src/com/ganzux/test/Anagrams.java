package com.ganzux.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Anagrams {

	private static List<List<String>> getAnagrams(String[] anagrams){
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String word : anagrams){

			String key = getHash(word);
			List<String> list = null;

			if (map.containsKey(key)){
				list = map.get(key);
			} else {
				list = new ArrayList<String>();
			}

			list.add(word);
			map.put(key, list);
		}

		List<List<String>> anagramsFinalList = new ArrayList<List<String>>();
		Set<String> keys = map.keySet();
		for (String k : keys){
			List<String> values = map.get(k);
	    	anagramsFinalList.add(values);
		}

		return anagramsFinalList;
	}
	
	private static String getHash(String word){
		char[] chars = word.toCharArray();

		// sort 1
		//Arrays.sort(chars);
		
		// sort 2
		char[] sortedChars = getSortedString(chars);
		System.out.println("DEBUG: " + new String(chars));

		return new String(chars).toLowerCase();
	}
	
	public static void main(String[] args){
		String[] anagrams = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		anagrams = new String[]{"ice", "cei", "cheese", "pool", "loop"};
		List<List<String>> anagramsFinalList = getAnagrams(anagrams);
		
		for (List<String> anam : anagramsFinalList){
			for (String s : anam){
				System.out.print(s + ", ");
			}
			System.out.println("");
		}
	}
	
	private static char[] getSortedString(char[] word){

		int length = word.length;

		char[] exit = new char[length];

		for(int i = 0 ; i < length ; i++){
			   for(int j = i + 1 ; j < length ; j++){
			      if (word[j] < word[i]) {
			          char temp = word[i];
			          word[i] = word[j];
			          word[j] = temp;
			      }
			   }
			}

		return exit;
	}
}
