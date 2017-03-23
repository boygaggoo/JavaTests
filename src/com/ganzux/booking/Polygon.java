package com.ganzux.booking;

import java.util.Scanner;

/*
 * Problem
Identify whether four sides (given by four integers) can form a square, a rectangle, or neither.
Input: You will receive an list of strings, each containing four space-separated integers, which
represent the length of the sides of a polygon. The input lines will follow the 'A B C D' order
as in the following representation:
|-----A-----|
|           |
|           |
D           B
|           |
|           |
|-----C-----|
Output: A single line which contains 3 space-separated integers; representing the number of squares,
number of rectangles, and number of other polygons with 4 sides. Note that squares shouldn't be
counted as rectangles. Invalid polygons should also be counted as 'other polygons'.
Constraints: The four integers representing the sides will be such that: -2000 <=X <= 2000
(Where X represents the integer)
Sample Input:
36 30 36 30
15 15 15 15
46 96 90 100
86 86 86 86
100 200 100 200
-100 200 -100 200
Sample Output: 2 2 2
 */
public class Polygon {

	    public static void main(String args[]) throws Exception {
	    	Scanner scan = new Scanner(System.in);

	        int squares = 0;
	        int rectangles = 0;
	        int others = 0;
	        
	        while (scan.hasNextInt()) {

	            final int a = scan.nextInt();
	            final int b = scan.nextInt();
	            final int c = scan.nextInt();
	            final int d = scan.nextInt();

	            // others
	            if (a < 1 || b < 1 || c < 1 || d < 1){
	            	others++;
	            }

	            // squares
	            else if (a == b && b == c && c == d){
	                squares++;
	            }

	            // rectangles
	            else if (a == c && b == d && a != b){
	                rectangles++;
	            }

	            // others
	            else {
	                others++;
	            }
	        }
	        
	        scan.close();
	        
	        System.out.println(squares + " " + rectangles + " " + others);
	}
}
