package stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

import linkedList.Node;

public class Stack {
	
	

	Node top;
	Node bottom;
	int size;
	//private static  Stack stack;
	
	static void Stack(Stack s) {
		s = new Stack();
	}
	
	public static void main(String[] args) {
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		stack1.push(2);
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		stack1.print();
		System.out.println("length of stack1:" + len(stack1) + " length of stack2:" + len(stack2));
	}
	
	public static int len(Stack stack) {
		return stack.size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	private void push(int value) {
		Node node = new Node();
		node.value = value;
		
		if(size >= 4)
			return; // In this stack implementation the number won't be added if the size has reached 4. As it is the default size.
		
//		if(contains(node.value)) {
//			return; // in this stack implementation of code. The number won't be added if value is already present in the stack.
//		} else
			if(size==0) {
			top = node;
			bottom = node;
		} else {
			node.next = top;
			top = node;
		}
		size++;
	}
	
	private boolean contains(int value) {
		Node node = top;
		
		while(node != null) {
			if(node.value == value)
				return true;
			node = node.next;
		}
			
		return false;
	}

	private int pop() throws EmptyStackException {
		Node node = top;
		int num = node.value;
		
		if(size == 0) {
			// return -1; // in this version it will return -1 as default value if empty
			throw new EmptyStackException();
		} else {
			node = node.next;
			top = node;
			size--;
		}
		
		return num;
	}
	
	private void print() {
		Node node = top;
		
		while(node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

}
