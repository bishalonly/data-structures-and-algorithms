package stack;

import java.util.EmptyStackException;

import stack.Node;

public class Stacks<E> {
	
	Node<E> top;
	Node<E> bot;
	int size;

	public static void main(String[] args) {
		Stacks<Integer> st = new Stacks();
		st.push(1);
		st.push(2);
		Stacks<String> string = new Stacks();
		string.push("best");
		string.push("is");
		string.push("Bishal");
		st.peek();
		st.pop();
		st.peek();
		string.peek();
		string.pop();
		string.peek();
		string.pop();
		string.peek();
	}
	
	private void peek() {
		System.out.println(top.value);
	}

	public static int len(Stacks stacks) {
		return stacks.size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	private void push(E e) {
		Node<E> node = new Node();
		node.value = e;
		
		if(size >= 4)
			return; // In this stack implementation the number won't be added if the size has reached 4. As it is the default size.
		
		if(contains(node.value)) {
			return; // in this stack implementation of code. The number won't be added if value is already present in the stack.
		} else
			if(size==0) {
			top = node;
			bot = node;
		} else {
			node.next = top;
			top = node;
		}
		size++;
	}
	
	private boolean contains(E e) {
		Node<E> node = top;
		
		while(node != null) {
			if(node.value == e)
				return true;
			node = node.next;
		}
			
		return false;
	}

	private E pop() throws EmptyStackException {
		Node<E> node = top;
		E num = node.value;
		
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
		Node<E> node = top;
		
		while(node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

}
