package resursion;

public class Power {
	
	public static void main(String[] args) {
		System.out.println(powerOf(4,4));
	}
	
	public static long powerOf(long base,int exponent) {
		//break point of method
		if(exponent == 0) return 1;
		
		// multiplying the base times the exponent to get the value
		return base * powerOf(base,exponent -1);
	}

}
