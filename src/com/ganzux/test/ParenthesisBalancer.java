package com.ganzux.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//QUESTION:
//--------
//Given a set of matching parenthesis
//- Open and Closed Rounded : '(' and ')'
//- Open and Closed Square  : '[' and ']'
//- Open and Closed Curly   : '{' and '}'
//
//Write an algorithm that checks if a string (composed by only parenthesis) is balanced or not.
//
//EXAMPLES:
//--------
//"[((){})]"     --> Balanced
//
//"[((){[])}]"   --> Not Balanced
//
public class ParenthesisBalancer {
	
	private static Map<Character, Character> myParentMap = new HashMap<Character, Character>();
	static{
	    myParentMap.put(')', '(');
	    myParentMap.put(']', '[');
	    myParentMap.put('}', '{');
	}
	
	public static boolean balanced(String s){

	    Stack<Character> myStack = new Stack<Character>();
	    
	    for (int i = 0; i < s.length(); i++){
	        char c = s.charAt(i);
	        // if it is a starting parenthesis, we put it on the Stack
	        if (myParentMap.get(c) == null){
	            myStack.push(c);
	        }
	        // "(((((((((((((((((((((("  ->  "( 50"
	        // "([{([{([{([{([{([{([{([{([{"   -> "([{" 10
	        // Compress???
	        

	        // it is a closing parenthesis
	        else {
	            if (myStack.isEmpty()){
	                return false;
	            }

	            char top = myStack.pop(); // Throwing exception. stack is offering an isEmpty()
	            if (myParentMap.get(c) != top){
	                return false;
	            }
	        }
	    }

	    return myStack.isEmpty();
	}

	// Test Cases:
	// "" T
	// "([{" F
	// ")}]" F
	// "(}" F 
	// "(]" F
	// "[)" "{)" F
	// "{[()]}" T
	// "{[()]}(({[]}))" T
	// " AS" F
	// null -> NullPointerException


}
