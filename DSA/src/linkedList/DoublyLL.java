package linkedList;

public class DoublyLL {
	int size;
	DNode head;
	DNode tail;
	static DoublyLL dll = new DoublyLL();
	
	public static void main(String[] args) {
		dll.addTop(10);
		dll.addLast(30);
		dll.addTop(20);
		dll.addLast(40);
		dll.addTop(25);
		dll.addMid(8, 24);
		dll.deleteTop();
		dll.deleteLast();
		dll.deleteMid(2);
		dll.print();
		dll.printReverse();
		dll.status();
	}
	
	private void addTop(int value) {
		DNode n = new DNode();
		n.value = value;
		
		if(size == 0) {
			head = n;
			tail = n;
		} else {
			head.prev = n;
			n.next = head;
			head = n;
		}
		size++;
	}
	
	private void deleteTop() {
		if(size == 0)
			return;
		if(size==1) {
			tail = null;
			head = null;
		} else {
			head = head.next;
			head.prev = null;
		}
		size--;
	}
	
	private void addLast(int value) {
		DNode n = new DNode();
		n.value = value;
		
		if(size == 0) {
			addTop(value);
			return;
		}else {
			tail.next = n;
			n.prev = tail;
			tail = n;
		}
		
		size++;
	}
	
	private void deleteLast() {
		if(size == 0)
			return;
		if(size==1) {
			tail = null;
			head = null;
		} else {
			//tail.prev.next = null;
			tail = tail.prev;
			tail.next = null;
		}
		size--;
	}
	
	private void addMid(int index, int value) {
		DNode newNode = new DNode();
		newNode.value = value;
		DNode n = head;
		DNode temp =  head ;
		int i = 0;
		
		if (index == 0){
			addTop(value);
			return;
		}else if(index >= size) {
			addLast(value);
			return;
		} else {
			while (i < index) {
				temp = n;
				n = n.next;
				i++;
			}
			{
				//this is a different logic where only one extra node is used for inserting.
				newNode.next = n;
				n.prev.next = newNode;
				newNode.prev = n.prev;
				n.prev = newNode;
			} 
//			{
			//this is another logic where two extra nodes are used for inserting
//				newNode.next = n;
//				newNode.prev = temp;
//				temp.next = newNode;
//				n.prev = newNode;
//			}
		}
		size++;
	}
	
	private void deleteMid(int index) {
		DNode n = head;
		DNode temp = head;
		int i = 0;
		
		if (index == 0) {
			deleteTop();
			return;
		}else if(index >= size - 1) {
			deleteLast();
			return;
		} else {	
			while (i < index) {
				temp = n;
				n = n.next;
				i++;
			}
			temp.next = n.next;
			n.next.prev = temp;
		}
		size--;
	}
	
	private void print() {
		DNode n = head;
		
		while(n != null) {
			System.out.print(n.value );
			if(n.value != tail.value)
				System.out.print(" -> ");
			n = n.next;
		}
		System.out.println(" ");
	}
	
	private void printReverse() {
		DNode n = tail;
		
		while(n != null) {
			System.out.print(n.value);
			if(n.value != head.value)
				System.out.print(" -> ");
			n = n.prev;
		}
		System.out.println(" ");
	}
	
	private void status() {
		System.out.println("head: " + dll.head + "\n"
				+ "tail: " + dll.tail + "\n"
				+ "head.value: " + dll.head.value + "\n"
				+ "tail.value: " + dll.tail.value + "\n"
				+ "size: " + dll.size + "\n");
	}

}
