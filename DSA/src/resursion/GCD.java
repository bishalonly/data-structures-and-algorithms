package resursion;

public class GCD {

	public static void main(String[] args) {
		// 
		System.out.println(hcf(32,104));
	}
	
	//this is euclidean's algorithm
	public static int hcf(int num1, int num2) {
		if(num2 == 0) return num1;
		//break point, once test few numbers in paper, it will help you understand this logic
		
		
		return hcf(num2, num1%num2);
	}

}
