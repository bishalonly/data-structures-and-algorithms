package resursion;

public class Decimal2Binary {
	public static void main(String[] args) {
		System.out.println(decimalToBinary(8));
	}
	
	public static int decimalToBinary(int num) {
		if(num == 0) return 0;
		
		
		return (num%2) + decimalToBinary(num/2) * 10;
	}

}
