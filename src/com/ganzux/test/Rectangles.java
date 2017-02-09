package com.ganzux.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rectangles {

	/*
	"(1,2),(1,3),(2,2),(2,3),(1,2),(1,3),(2,2),(2,3)"

	Given two rectangles on a cartesian coordinate plane.
	Determine the number of times the area of overlap between
	the two rectangles fits inside of the first given rectangle.
*/

	public static void main(String[] args){
		System.out.println( getIntervalIntersection(1, 3,
													5, 3,
													1, 9,
													5, 9,

													3, 5,
													9, 5,
													3, 8,
													9, 8) );
	}

	public static int getIntervalIntersection(int pr11x, int pr11y,
			int pr12x, int pr12y,
			int pr13x, int pr13y,
			int pr14x, int pr14y,
			int pr21x, int pr21y,
			int pr22x, int pr22y,
			int pr23x, int pr23y,
			int pr24x, int pr24y){
	 
		int xMinInside = getMinMiddle(pr11x, pr12x, pr13x, pr14x, pr21x, pr22x, pr23x, pr24x);
		int xMaxInside = getMaxMiddle(pr11x, pr12x, pr13x, pr14x, pr21x, pr22x, pr23x, pr24x);

		int yMinInside = getMinMiddle(pr11y, pr12y, pr13y, pr14y, pr21y, pr22y, pr23y, pr24y);
		int yMaxInside = getMaxMiddle(pr11y, pr12y, pr13y, pr14y, pr21y, pr22y, pr23y, pr24y);
	    
		int x = xMaxInside - xMinInside;
		int y = yMaxInside - yMinInside;
		
		return x * y;
	}
	    
	private static int getMinMiddle(Integer... x){
		x = removeAndOrderDuplicates(x);
		return x[1];
	}
	
	private static int getMaxMiddle(Integer... x){
		x = removeAndOrderDuplicates(x);
		return x[x.length - 2];
	}
	
	private static Integer[] removeAndOrderDuplicates(Integer[] x){
		Arrays.sort(x);
		List<Integer> list = new ArrayList<Integer>();

		for (int num : x){
			if (!list.contains(num)){
				list.add(num);
			}
		}

		return list.toArray(new Integer[list.size()]);
	}
}
