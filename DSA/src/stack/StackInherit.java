package stack;

import java.lang.reflect.Method;

import linkedList.SingleLL;

/*
 * 
 * 1> Stack question: implement a stack where push(), pop() and minimum() is present.
minimum() will return the minimum value present in stack. 
push(), pop() and minimum() must take O(1) time complexity.

*
*/

public class StackInherit {
	static SingleLL st ;
	static StackInherit si = new StackInherit();
	int min = Integer.MAX_VALUE;
	static SingleLL minimum;
	// implementing global minimum variable to store the minimum value pushed to the stack.
	// we can return the value in O(1) time complexity.
	/* 
	 * #########
	 * earlier I thought making a minimum variable will get us the answer.
	 * But after I saw the actual answer I understood that this approach is wrong. 
	 * suppose we pop out the minimum element, it will still show the minimum element as same.
	 * The correct approach is to  create a stack name minimum and push the minimum values to it.
	 * #########
	 */
	public StackInherit() {
		st = new SingleLL();
		minimum = new SingleLL();
	}

	public static void main(String[] args) {
		si.push(5);
		si.push(14);
		si.push(2);
		si.push(1);
		si.push(35);
		si.minimum();
		si.pop(); si.peek();
		si.pop(); si.peek();
		si.pop(); si.peek();
		si.minimum();
		
	}
	
	private void Method(int value) {
		if(minimum.size == 0) {
			minimum.addLast(value);
		}else {
			if(value < minimum.tail.value)
				minimum.addLast(value);
		}
	}
	
	private  void push(int value) {
		if(value < min)
			min = value;
		st.addLast(value);
		if(minimum.size == 0) {
			minimum.addLast(value);
		}else {
			if(value < minimum.tail.value)
				minimum.addLast(value);
		}
		System.out.println(value + " added to stack.");
	}
	
	private void pop() {
		int value = st.tail.value;
		if(value == minimum.tail.value)
			minimum.deleteLast();
		System.out.print(value + " deleted from stack.");
		st.deleteLast();
	}
	
	private void peek() {
		int value = st.tail.value;
		System.out.println(value);
	}
	
	private void minimum() {
		System.out.println(minimum.tail.value + " is the minimum value in the stack.");
	}

}
