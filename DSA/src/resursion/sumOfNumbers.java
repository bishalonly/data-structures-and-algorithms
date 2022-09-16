package resursion;

public class sumOfNumbers {

	public static void main(String[] args) {
		System.out.println(sumOfNum(123456789));

	}
	
	public static int sumOfNum(int num) {
		if(num == 0) return 0; //break point of recursion
		
		//we are getting the reminder of the number by % 10-remainder
		//we are getting rest of the number by / 10-dividing
		return num%10 + sumOfNum(num/10);
	}

}
