package circularLinkedList;

import java.util.LinkedList;

import linkedList.Node;

public class CircularLL {

	Node head;
	Node tail;
	int size;
	static CircularLL cll = new CircularLL();
	
	public static void main(String[] args) {
		
		cll.addTop(5);
		cll.deleteLast();
		cll.addLast(6);
		cll.addLast(7);
		cll.addLast(8);
		
		cll.deleteTop();
		cll.deleteLast();
		cll.status();
		
	}
	
	private void deleteTop() {
		head = head.next;
		tail.next = head;
		size--;
	}
	
	private void deleteLast() {
		Node n = head;
		if(size ==1) { // this should be if size =1 then 
			deleteTop();
			return;
		} else 
			while(n.next != tail) {
				n = n.next;
		}
		n.next = head;
		tail = n;
		size--;
	}
	
	private void deleteMid(int index) {
		if(index == 0) {
			if(size == 1) {
				head = null;
				tail = head;
				size--;
			} else {
				deleteTop();
				return;
			}
		} else if(index == size-1)
			deleteLast();
		else {
			Node n = head;
			Node temp = n;
			int i=0;
			while(i != index) {
				i++;
				temp = n;
				n = n.next;
			}
			temp.next = n.next;
			size--;
		}
	}
	
	private void status() {
		System.out.println("head: " + cll.head + "\n"
				+ "tail: " + cll.tail + "\n"
				+ "head.value: " + cll.head.value + "\n"
				+ "tail.value: " + cll.tail.value + "\n"
				+ "cll.size: " + cll.size + "\n");
	}

	private void addTop(int i) {
		Node node = new Node();
		node.value = i;
		
		if(size == 0) {
			head = node;
			tail = node;
			node.next = node;
		} else {
			tail.next = node;
			node.next = head;
			head = node;
		}
		size++;
	}
	
	private void addLast(int value) {
		Node node = new Node();
		node.value = value;
		if(size == 0) {
			addTop(value);
			return;
		} else {
			
			tail.next = node;
			node.next = head;
			tail = node;
			size++;
		}
		
	}
	
	private void addMid(int value, int index) {
		Node node = new Node();
		node.value = value;
		Node n = head;
		if(index == 0)
			addTop(value);
		else if(index < size) {
			for(int i=0; i<=index; i++) {
				if(i == index-1) {
					node.next = n.next;
					n.next = node;
				}
				n = n.next;
			}
		} else addLast(value);
	}
	
	private void print() {
		Node n = head;
		while(n.next != tail.next) {
			System.out.print(n.value + " ");
			n= n.next;
		}
		System.out.println(n.value + " ");
	}

}
