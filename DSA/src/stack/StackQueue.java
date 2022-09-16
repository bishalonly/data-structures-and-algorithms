package stack;

import java.util.Stack;

public class StackQueue { 
	static Stack<Integer> s1, s2;
	
	public StackQueue() {
		s1 = new Stack();
		s2 = new Stack();
	}
	
	public static void main(String[] args) {
		StackQueue sq = new StackQueue();
		sq.enQueue(4);
		sq.enQueue(3);
		
		System.out.println(sq.deQueue());
		System.out.println(sq.deQueue());
		System.out.println(sq.deQueue());
	}
	
	private void shift() {
		if(s2.isEmpty()) {
			while (!s1.isEmpty()) {
				int pop = s1.pop();
				s2.push(pop);
			}
		} 
	}
	
	private void enQueue(int value) {
		s1.push(value);
	}
	
	private int deQueue() {
		shift();
		return s2.pop();
	}
	
	private int peek() {
		shift();
		return s2.peek();
	}
	
	

}
