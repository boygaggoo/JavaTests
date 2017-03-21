package com.ganzux.sudoku;

import java.util.HashMap;
import java.util.Map;
/*
 *
 -----------------------
|   4 3 | 7     | 9   8 |
|     5 |   3   |       |
|   1   |       | 3     |
 -----------------------
| 6     |   2 7 |       |
| 4   7 |       | 1   3 |
|       | 5 4   |     9 |
 -----------------------
|     2 |       |   3   |
|       |   5   | 4     |
| 5   4 |     1 | 2 6   |
 -----------------------
 -----------------------
| 2 4 3 | 7 1 6 | 9 5 8 |
| 9 8 5 | 2 3 4 | 7 1 6 |
| 7 1 6 | 8 9 5 | 3 4 2 |
 -----------------------
| 6 3 9 | 1 2 7 | 5 8 4 |
| 4 5 7 | 9 6 8 | 1 2 3 |
| 8 2 1 | 5 4 3 | 6 7 9 |
 -----------------------
| 1 6 2 | 4 7 9 | 8 3 5 |
| 3 7 8 | 6 5 2 | 4 9 1 |
| 5 9 4 | 3 8 1 | 2 6 7 |
 -----------------------
 */
public class SudokuSolver {
	
	private static final int _ = 0;

	public static void main(String[] args){
		int[][] sudoku = new int[][]{

			{_, 4, 3,  7, _, _,  9, _, 8},
			{_, _, 5,  _, 3, _,  _, _, _},
			{_, 1, _,  _, _, _,  3, _, _},

			{6, _, _,  _, 2, 7,  _, _, _},
			{4, _, 7,  _, _, _,  1, _, 3},
			{_, _, _,  5, 4, _,  _, _, 9},

			{_, _, 2,  _, _, _,  _, 3, _},
			{_, _, _,  _, 5, _,  4, _, _},
			{5, _, 4,  _, _, 1,  2, 6, _}};
		/*sudoku = new int[][]{
				{_, _, _,  _, _, _,  _, _, _},
				{_, _, _,  _, _, _,  _, _, _},
				{_, _, _,  _, _, _,  _, _, _},

				{_, _, _,  _, _, _,  _, _, _},
				{_, _, _,  _, _, _,  _, _, _},
				{_, _, _,  _, _, _,  _, _, _},

				{_, _, _,  _, _, _,  _, _, _},
				{_, _, _,  _, _, _,  _, _, _},
				{_, _, _,  _, _, _,  _, _, _}};*/
			sudoku = new int[][]{
				{3, 7, 4,  2, 5, 8,  9, 6, 1},
				{6, 2, 8,  1, 7, 9,  4, 3, 5},
				{1, 5, 9,  4, 3, 6,  8, 2, 7},

				{2, 4, 3,  5, 9, 7,  6, 1, 8},
				{8, 1, 7,  6, 4, 2,  3, 5, 9},
				{5, 9, 6,  8, 1, 3,  2, 7, 4},

				{_, _, _,  _, _, _,  _, _, _},	// {9, 3, 5, 7, 6, 4, 1, 8, 2},
				{_, _, _,  _, _, _,  _, _, _},	// {7, 6, 2, 9, 8, 1, 5, 4, 3},
				{_, _, _,  _, _, _,  _, _, _}};	// {4, 8, 1, 3, 2, 5, 7, 9, 6}};
			
		boolean[][] mask = createMask(sudoku);

		solve(0, 0, sudoku, mask, false);
		print(sudoku);
	}
	
	private static void solve(int i, int j, int[][] sudoku, boolean[][] mask, boolean solved){
		
		if (i > 8 || j > 8){
			if (isValid(sudoku)){
				solved = true;
			}
		}

		if (!solved){
			final boolean isInitialValue = mask[i][j];
	
			int nextJ = j + 1;
			int nextI = i;
	
			if (nextJ > 8){
				nextJ = 0;
				nextI++;
			}
	
			// There is not true value
			if (!isInitialValue){
				for (int k = 1 ; k <= 9 ; k++){

					sudoku[i][j] = k;
	
					if (isValid(sudoku)){
						solve(nextI, nextJ, sudoku, mask, solved);
					} else {
						sudoku[i][j] = _;
					}

				}
			}
	
			// There is a true value
			else{
				solve(nextI, nextJ, sudoku, mask, solved);
			}
	
		}
	}
	
	private static boolean isValid(final int[][] sudoku){

		Map<Integer, Map<Integer,Boolean>> rowsMap = new HashMap<Integer, Map<Integer,Boolean>>();
		Map<Integer, Map<Integer,Boolean>> colsMap = new HashMap<Integer, Map<Integer,Boolean>>();
		Map<String, Map<Integer,Boolean>> squaMap = new HashMap<String, Map<Integer,Boolean>>();

		for (int i = 0 ; i < sudoku.length ; i++){

			rowsMap.put(i, new HashMap<Integer,Boolean>());

			for (int j = 0 ; j < sudoku[i].length ; j++){

				// current array value
				int currentValue = sudoku[i][j];

				if (_ != currentValue){

					if (colsMap.get(j) == null){
						colsMap.put(j, new HashMap<Integer,Boolean>());
					}
					
					// current map for the row
					Map<Integer, Boolean> rows = rowsMap.get(i);
					
					// current map for the column
					Map<Integer, Boolean> columns = colsMap.get(j);

					// row check
					if (rows.get(currentValue) != null){
						return false;
					}
					rows.put(currentValue, true);
					
					// column check
					if (columns.get(currentValue) != null){
						return false;
					}
					columns.put(currentValue, true);
					
					// square check
					int firstPart = i / 3;
					int secondPart = j / 3;
					String id = firstPart + "" + secondPart;
					if (squaMap.get(id) == null){
						squaMap.put(id, new HashMap<Integer,Boolean>());
					}
					// current map for the square
					Map<Integer, Boolean> squares = squaMap.get(id);
					// square check
					if (squares.get(currentValue) != null){
						return false;
					}
					squares.put(currentValue, true);
				}
			}
		}

		return true;
	}
	
	private static boolean isValid(final int[][] sudoku, int i, int j){

		int currentValue = sudoku[i][j];

		for (int k = 0 ; k < 9 ; k++){
			final int columnValue = sudoku[i][k];
			if (currentValue == columnValue && i != k && _ != columnValue){
				return false;
			}

			final int rowValue = sudoku[k][j];
			if (columnValue == rowValue && i != k && _ != rowValue){
				return false;
			}
		}
        int boxRowOffset = (i / 3) * 3;
        int boxColOffset = (j / 3) * 3;
        for (int k = 0; k < 3; ++k){
            for (int m = 0; m < 3; ++m){
            	final int newI = boxRowOffset + k;
            	final int newJ = boxColOffset + m;
                if (currentValue == sudoku[newI][newJ] && newI != i && newJ != j){
                    return false;
                }
            }
	}

		return true;
	}
	
	private static void print(int[][] sudoku){

		for (int i = 0 ; i < sudoku.length ; i++){
			for (int j = 0 ; j < sudoku.length ; j++){

				int intCurrentValue = sudoku[i][j];
				String printValue = (_ == intCurrentValue ? "_" : intCurrentValue + "");

				System.out.print(printValue + " ");
				if (j != 0 && (j + 1) % 3 == 0){
					System.out.print("\t");
				}
			}
			System.out.print("\r\n");
			if (i != 0 && (i + 1) % 3 == 0){
				System.out.print("\r\n");
			}
		}

	}

	private static boolean[][] createMask(int[][] sudoku){
		boolean[][] mask = new boolean[sudoku.length][sudoku[0].length];
		
		for (int i = 0 ; i < sudoku.length ; i++){
			for (int j = 0 ; j < sudoku.length ; j++){
				int intCurrentValue = sudoku[i][j];
				if (_ != intCurrentValue){
					mask[i][j] = true;
				} else {
					mask[i][j] = false;
				}
			}
		}
		return mask;
	}
}