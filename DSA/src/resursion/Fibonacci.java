package resursion;

import java.util.Arrays;

public class Fibonacci {

	public static void main(String[] args) {
		//System.out.println(fib(10));
		
		
		// practising multi-dimensional array
		int[][] arr = new int[3][4];
		//System.out.println(arr); 
		int[][][] arr3 = new int[2][3][4];
		int[] arr2= {1,2,3,21,23};
		int[] arr1 = new int[5];
		System.out.println(Arrays.deepToString(arr3));
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}
	
	// code to print the fibonacci nth element
	public static int fib(int n) {
		if(n==0 || n==1) return n;
		return fib(n-1) + fib(n-2);
	}

}
