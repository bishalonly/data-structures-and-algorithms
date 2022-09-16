package ArrayProblems;

import java.util.Arrays;

public class Matrix {

	public static void main(String[] args) {
		//A matix is a 2D array which has rows and columns
		
		int[][] arr = new int[3][3]; // declaring an 2d array
		int[][] ar = {{1,2,3,7},{1,2,4,5},{14,02,43,5},{1,21,14,5}}; // Initializing an 2d nxn array
		
		int[][] array = {{1,2,3},{4,5,6}};
		//System.out.println("transpose array "+Arrays.deepToString(transpose(array)));
		//System.out.println("original array "+Arrays.deepToString(ar));
		//System.out.println("transpose array "+Arrays.deepToString(transpose(ar)));
		
		
		
		int A[][] = { {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3}};
		
		System.out.println("transpose array "+Arrays.deepToString(rotate90(ar)));

	}
	
	public static int[][] transposeNM(int[][] arr) { 
		// transpose of NxM matrix
		int rows = arr.length;
		int cols = arr[0].length;
		int[][] transpose = new int[cols][rows];
		
		
		for(int i=0; i<cols; i++) {
			for(int j=0; j<rows; j++) {
				transpose[i][j] = arr[j][i];
			}
		}
		
		return transpose;
	}
	
	public static int[][] transposeNN(int[][] arr) {
		// transpose of NxN matrix
		int rows = arr.length;
		int cols = arr[0].length;
		int[][] transpose = new int[rows][cols];
		
		
		for(int i=0; i<cols; i++) {
			for(int j=0; j<rows; j++) {
				transpose[i][j] = arr[j][i];
			}
		}
		
		return transpose;
	}

	public static int[][] reverse(int[][] arr) {
		int cols = arr[0].length;
		int rows = arr.length;
		
		
		for (int i = 0; i < rows; i++) {
			int start = 0;
			int end = cols - 1;
			while (start < end) {
				int temp = arr[i][start];
				arr[i][start] = arr[i][end];
				arr[i][end] = temp;

				start++;
				end--;
			} 
		}
		return arr;
	}

	public static int[][] rotate90(int[][] arr) {
		int[][] rotated;
		if(arr.length == arr[0].length) {
			rotated = new int[arr.length][arr.length];
			rotated = transposeNN(arr);
			rotated = reverse(rotated);
		} else {
			rotated = new int[arr[0].length][arr.length];
			rotated = transposeNM(arr);
			rotated = reverse(rotated);
		}
		
		
		return rotated;
	}
}
