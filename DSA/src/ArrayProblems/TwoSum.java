package ArrayProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
		int[] arr = {2,7,8,11};
		System.out.println(Arrays.toString(bruteForce(arr,10)));
		System.out.println(Arrays.toString(optimisedCode(arr,10)));
	}
	
	public static int[] bruteForce(int[] array, int target) {
		for(int i=0; i<array.length; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[i] + array[j] == target) {
					return new int[] {i,j};
				}
			}
		}
		//throw new IllegalArgumentException("no solution found");
		
		return new int[2]; // TC: O(N^2) & SC: O(1)
	}
	
	public static int[] optimisedCode(int[] array, int target) {
		Hashtable<Integer,Integer> table = new Hashtable<>();
		int[] result = new int[2];
		
		for(int i=0; i<array.length;i++) {
			if(table.containsKey(target- array[i])) {
				result[1] = i;
				result[0] = table.get(target-array[i]);
				return result;
			}
			
			table.put(array[i], i);
			//System.out.println(table);
		}
		//throw new IllegalArgumentException("no answer found");
		return result; // TC: O(N) & SC: O(N)
	}

}
