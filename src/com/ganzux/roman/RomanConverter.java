package com.ganzux.roman;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public abstract class RomanConverter {
	
	
	
	private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public final static String toRoman(int number) {
        int l =  map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number - l);
    }

	private enum ROMAN {
		I('I', 1),
		V('V', 5),
		X('X', 10),
		L('L', 50),
		C('C', 100),
		D('D', 500),
		M('M', 1000);
		
		private final char name;
		private final int value;

	    private ROMAN(char name, int value) {
	        this.name = name;
	        this.value = value;
	    }

	    public boolean equals(char otherName) {
	    	return name == otherName;
	    }
	}

	public static void main(String[] args) throws Exception{
		for (int i = 1 ; i < 4000 ; i++){
			String romanNumber = convert(i);
			int latinNumber = convert(romanNumber);
			System.out.println(romanNumber + " - " + latinNumber + " - " + i);
		}
		
		
		for (int i = 1; i<= 100; i++) {
	        System.out.println(i+"\t =\t "+RomanConverter.toRoman(i));
	    }
	}
	
	public static String convert(int number) throws Exception{
		
		if (number < 1 || number > 3999){
			throw new Exception("Valid range: 1 - 3999");
		}
		
		Stack<ROMAN> stack = new Stack<ROMAN>();

		String numberStr = String.valueOf(number);
		char[] numberParts = numberStr.toCharArray();
		
		int length = numberParts.length;

		for (int position = length - 1 ; position >= 0 ; position--){
			int num = Integer.valueOf((char)numberParts[position] + "");

			// _ _ _ _
			if (position == length - 4){
				stack.addAll(convertSymbols(num, ROMAN.M, null, null));
			}
			
			// _ _ _
			if (position == length - 3){
				stack.addAll(convertSymbols(num, ROMAN.C, ROMAN.D, ROMAN.M));
			}
			
			// _ _
			if (position == length - 2){
				stack.addAll(convertSymbols(num, ROMAN.X, ROMAN.L, ROMAN.C));
			}

			// _
			if (position == length - 1){
				stack.addAll(convertSymbols(num, ROMAN.I, ROMAN.V, ROMAN.X));
			}
			
		}

		StringBuilder sb = new StringBuilder();
		
		while (!stack.isEmpty()){
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
	
	public static int convert(String number) throws Exception{
		int converted = 0;

		// separate in groups and calc the sum of all of them
		char lastChar = ' ';
		List<Character> chars = new ArrayList<Character>();
		for (char c : number.toCharArray()){
			if (!isInGroup(lastChar, c)){
				converted += count(chars);
				chars = new ArrayList<Character>();
			}
			chars.add(c);
			lastChar = c;
		}
		converted += count(chars);

		return converted;
	}

	private static int count(List<Character> chars){
		int count = 0;

		char lastChar = ' ';
		for (Character c : chars){
			if (iNeedToSubstract(lastChar, c)){
				count += findRoman(c).value;
				count -= findRoman(lastChar).value;
				count -= findRoman(lastChar).value;
			}
			else {
				count += findRoman(c).value;
			}
			lastChar = c;
		}
		
		return count;
	}

	private static boolean iNeedToSubstract(char a, char b){

		if (ROMAN.I.name == a && ROMAN.V.name == b
				|| ROMAN.I.name == a && ROMAN.X.name == b
				|| ROMAN.X.name == a && ROMAN.L.name == b
				|| ROMAN.X.name == a && ROMAN.C.name == b
				|| ROMAN.C.name == a && ROMAN.D.name == b
				|| ROMAN.C.name == a && ROMAN.M.name == b){
			return true;
		}
		
		return false;
	}
	
	private static ROMAN findRoman(char c){
		if (ROMAN.I.name == c){
			return ROMAN.I;
		}
		if (ROMAN.V.name == c){
			return ROMAN.V;
		}
		if (ROMAN.X.name == c){
			return ROMAN.X;
		}
		if (ROMAN.D.name == c){
			return ROMAN.D;
		}
		if (ROMAN.L.name == c){
			return ROMAN.L;
		}
		if (ROMAN.C.name == c){
			return ROMAN.C;
		}
		if (ROMAN.D.name == c){
			return ROMAN.D;
		}
		if (ROMAN.M.name == c){
			return ROMAN.M;
		}
		
		return null;
	}
	private static boolean isInGroup(char a, char b){
		
		if (a == b || a == ' '){
			return true;
		}
		
		if (ROMAN.I.equals(a) && ROMAN.V.equals(b)
				 || ROMAN.I.equals(b) && ROMAN.V.equals(a)
				 || ROMAN.I.equals(a) && ROMAN.X.equals(b)
				 || ROMAN.I.equals(b) && ROMAN.X.equals(a)){
			return true;
		}
		
		if (ROMAN.X.equals(a) && ROMAN.L.equals(b)
				 || ROMAN.X.equals(b) && ROMAN.L.equals(a)
				 || ROMAN.X.equals(a) && ROMAN.C.equals(b)
				 || ROMAN.X.equals(b) && ROMAN.C.equals(a)){
			return true;
		}

		if (ROMAN.C.equals(a) && ROMAN.D.equals(b)
				 || ROMAN.C.equals(b) && ROMAN.D.equals(a)
				 || ROMAN.C.equals(a) && ROMAN.M.equals(b)
				 || ROMAN.C.equals(b) && ROMAN.M.equals(a)){
			return true;
		}
		
		return false;
	}

	private static Stack<ROMAN> convertSymbols(int number, ROMAN unit, ROMAN fith, ROMAN tenth){
		Stack<ROMAN> stack = new Stack<ROMAN>();

		// 1, 2, 3
		if (number < 4){
			for (int i = 0 ; i < number ; i++){
				stack.push(unit);
			}
		}

		// 4
		else if (number == 4){
			stack.push(fith);
			stack.push(unit);
		}

		// 5, 6, 7, 8
		else if (number < 9){
			for (int i = 5 ; i < number ; i++){
				stack.push(unit);
			}
			stack.push(fith);
		}

		else if (number == 9){
			stack.push(tenth);
			stack.push(unit);
		}

		return stack;
	}
}
