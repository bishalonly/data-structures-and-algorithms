package stack;

public class StackArray {
	int[] arr;
	int top;
	int size;
	
	public StackArray(int size) {
		arr = new int[size];
		top = -1;
		this.size = size;
	}
	
	public static void main(String[] args) {
		StackArray sa = new StackArray(4);
		sa.push(4);
		sa.push(3);
		sa.push(2);
		sa.push(1);
		sa.push(0);
		sa.peek();
		sa.pop();
		sa.peek();
		sa.pop();
		sa.peek();
		sa.pop();
		sa.peek();
		sa.pop();
		sa.peek();
		sa.pop();
		}
	
	public void push(int num) {
		if(top == size-1)
			System.out.println("stack is full.");
		else {
			//top++;
			arr[++top] = num;
		}
	}
	
	public void pop() {
		if(top == -1) {
			System.out.println("stack is empty");
		} else {
			int pop = arr[top];
			top--;
			System.out.println(pop +" is popped from the stack");
		}
	}
	
	public void peek() {
		if(top == -1) {
			System.out.println("stack is empty");
		} else
			System.out.println(arr[top]+" is peeked from stack.");
	}
	
	

}
