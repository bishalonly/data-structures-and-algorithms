package queue;

import linkedList.Node;

public class Queue {

	Node head;
	Node tail;
	int size;
	
	public static void main(String[] args) {
		
	}
	
	private void enQueue(int value) {
		Node n = new Node();
		n.value = value;
		
		if(head == null) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
		size++;
	}
	
	private int deQueue() {
		if(head == null) {
			System.out.println("Queue is empty");
			return -1;
		} else {
			int ans = head.value;
			head = head.next;
			size--;
			return ans;
		}
	}
	
	private int peek() {
		if(head == null) {
			System.out.println("Queue is empty");
			return -1;
		} else
			return head.value;
	}
	
	
	
}
