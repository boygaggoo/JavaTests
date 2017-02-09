package com.ganzux.test;

public class Corvil {

	/*Write a function:
	 
	that, given a non-empty zero-indexed array A of N integers, returns the minimum value from array A:
	For example, given:
	 
	A[0] = 1     A[1] = 2    A[2] = 3
	A[3] = 42    A[4] = 1    A[5] = -10
	 
	your function should return −10.
	 
	Assume that:
	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
	 
	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
	 
	Elements of input arrays can be modified.
	*/
	 
	public int solution(int[] A) {
	                int min = Integer.MAX_VALUE;
	                                for (int num : A){
	                                                if (num < min){
	                                                                min = num;
	                                                }
	                }
	                return min;
	}
	 
	 
	 
	 
	 
	 
	 
	/*
	You are given a non-empty string S consisting of N characters. In this problem we consider only strings that consist of lower-case English letters (a−z) and spaces.
	S can be divided into words by splitting it at the spaces and removing them. We want to reverse every word in S.
	For example, given S = "we test coders", there are three words: "we", "test" and "coders". Reversing the words gives "ew", "tset" and "sredoc".
	The goal is to return a string with every word in string S reversed and separated by spaces, so the result in the above example should be "ew tset sredoc". You can assume that if there are K spaces in S then there are exactly K + 1 words.
	Write a function:
	 
	class Solution { public String solution(String S); }
	 
	that, given a non-empty string S consisting of N characters, returns the reversal of every word of S.
	For example, given S = "we test coders", the function should return "ew tset sredoc", as explained above.
	Assume that:
	the length of S is within the range [1..100];
	string S consists only of lower-case letters (a−z) and spaces.
	 
	In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
	Task idea contributed by Stephen Law of Electrum.
	*/
	 
	public String solution2(String S) {
	                // StringBuilder better
	                String exit = "";
	 
	                for (String word : S.split(" ")){
	                                exit += reverse(word) + " ";
	                }
	 
	                return exit.substring(0, exit.length() - 1);
	}
	 
	 
	public static String reverse(String word){
	                String reverse = "";
	 
	                for (int i = word.length() - 1 ; i >= 0 ; i--){
	                                reverse += word.charAt(i);
	                }
	 
	                return reverse;
	}
	 
	 
	/*
	A non-empty zero-indexed array A consisting of N integers is given. A slice of that array is a pair of integers (P, Q) such that 0 ≤ P ≤ Q &lt; N. Integer P is called the beginning of the slice; integer Q is called the end of the slice. The number Q - P + 1 is called the size of the slice. A slice (P, Q) of array A is called ascending if the corresponding items form a strictly increasing sequence: A[P] &lt; A[P+1] &lt; ... &lt; A[Q−1] &lt; A[Q].
	Note that we consider a slice (P, P) consisting of one element to be ascending.
	For example, consider array A such that:
	    A[0] = 2
	    A[1] = 2
	    A[2] = 2
	    A[3] = 2
	    A[4] = 1
	    A[5] = 2
	    A[6] = -1
	    A[7] = 2
	    A[8] = 1
	    A[9] = 3
	Pair (0, 3) is a slice of array A of size 4 that is not ascending. Pair (2, 2) is a slice of size 1 that is ascending. Pair (4, 5) is a slice of size 2 that is ascending. Pairs (6, 7) and (8, 9) are other slices of size 2 that are ascending. There is no slice of array A that is ascending and has size greater than 2.
	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a zero-indexed array A consisting of N integers, returns the beginning of any ascending slice of A of maximal size.
	For instance, in the above example the function may return 4, 6 or 8 as explained above.
	For the following array A consisting of N = 3 elements:
	    A[0] = 30
	    A[1] = 20
	    A[2] = 10
	the function may return 0, 1 or 2, because all ascending slices of this array have size 1.
	Assume that:
	N is an integer within the range [1..150,000];
	each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
	 
	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
	 
	Elements of input arrays can be modified.
	*/
	 
	 
	public int solution3(int[] A) {
	                // the slice itself is always a solution
	                int exit = 0;
	               
	                for (int i = 0 ; i < A.length ; i++){
	                                int value = A[i];
	                                int nextValue = value;
	                                try {
	                                                nextValue = A[i+1];
	                                } catch(Exception e){}
	                                if (value < nextValue){
	                                                return i;
	                                }
	                }
	               
	                return exit;
	}

}
