package ArrayProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMissingNumber {
	public static void main(String[] args) {
		int[] arr = {1,2,3,3,5,6,7,8,10,8};
		int[] array = {1,2,3,4,5,6,8,9,10};
		
		System.out.println("singgle missing: " + findSingleMissingNumber(array));
		System.out.println("multiple missing: " +findMultipleMissingNumber(arr));
	}
	
	public static int findSingleMissingNumber(int array[]) {
		
		int num = 10;
		int sumOfNum = (num*(num+1))/2;
		int sumArray =0;
		
		for(int i: array) {
			sumArray += i;
		}
				
		return sumOfNum - sumArray;
	}
	
	public static String findMultipleMissingNumber(int arr[]) {
		Set<Integer> set = new HashSet<>();
		
		for(int i: arr) {
			if(!set.contains(i))
				set.add(i);
		}
		
		int[] missingNumber = new int[arr.length - set.size()];
		int j=0;
		for(int i =1; i<=arr.length;i++) {
			if(!set.contains(i)) {
				missingNumber[j] =i;
				j++;
			}
		}
	
		
		return Arrays.toString(missingNumber); 
	}

}
