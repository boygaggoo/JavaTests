package com.ganzux.test;

import java.util.ArrayList;
import java.util.List;

public class Calc {
	
	private static List<Character> validOperations = new ArrayList<Character>();
	
	static{
		validOperations.add('+');
		validOperations.add('-');
		validOperations.add('/');
		validOperations.add('*');
	}

	// Write a method that takes in a string of integers and + or - characters,
	// return an integer of the equation. For instance, if passed in a string "3 + 4"
	// return 7
	public static int calc(String str){

		String firstNumber = "0";
		String secondNumber = "0";
		String operation = "";

		for (char ch: str.toCharArray()){

			String n = "";
			try{
				n += Integer.parseInt(ch + "");
			} catch(Exception e){
				if (validOperations.contains(ch)){
					operation = ch + "";
				}
			}

			if (operation.isEmpty()){
				firstNumber += n;
			}else {
				secondNumber += n;
			}

		}

		switch(operation){
			case "+": return Integer.valueOf(firstNumber) + Integer.valueOf(secondNumber);
			case "-": return Integer.valueOf(firstNumber) - Integer.valueOf(secondNumber);
			case "*": return Integer.valueOf(firstNumber) * Integer.valueOf(secondNumber);
			case "/": return Integer.valueOf(firstNumber) / Integer.valueOf(secondNumber);
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		System.out.println(calc("2 + 5"));
		System.out.println(calc("2 - 5"));
		System.out.println(calc("2 * 5"));
		System.out.println(calc("10 / 2"));
		System.out.println(calc("- 2"));
		System.out.println(calc("8/"));
	}

}
