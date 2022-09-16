package linkedList;

public class SingleLL {
	public Node head;
	public int size;
	public Node tail;
	static SingleLL cll = new SingleLL();
	
	public void addTop(int value) {
		Node newNode = new Node();
		newNode.value = value;
		newNode.next = null;
		
		if(size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		
		size++;
	}
	
	public void add(int value, int index) {
		Node newNode = new Node();
		newNode.value = value;
		
		 if(index == 0) {
			addTop(value);
			return;
		}else if(index >= size) {
			addLast(value);
			return;
		} else {
			int i = 0;
			Node n = head;
			while(i<index-1) {
				n = n.next;
				i++;
			}
			newNode.next = n.next;
			n.next = newNode;
		}
		
		size++;
	}
	
	public Node addLast(int value) {
		Node newNode = new Node();
		newNode.value = value;
		if(size ==0) {
			addTop(value);
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		
		size++;
		return newNode;
	}
	
	public void print() {
	Node node = head;
	
		while(node != null ) {
			System.out.print(node.value);
			if(node != tail)
				System.out.print(" -> ");
			node = node.next;
		}
		System.out.println("");
	}
	
	public void deleteTop() {
		if(size == 0) {
			head = null;
			tail = null;
		}else 
			head = head.next;
		
		size--;
	}
	
	public void deleteLast() {
		Node n = head;
		Node temp = head;
		
		while(n != tail) {
			temp = n;
			n = n.next;
		}
		temp.next = null;
		tail = temp;
		
		size--;
	}
	
	public void deleteMid(int index) {
		Node n = head;
		Node temp = new Node();
		
		if(index == 0) {
			deleteTop();
			return;
		} else if(index >= size-1) {
			deleteLast();
			return;
		} else {
			for(int i=0; i<=index; i++) {
				if(i==index) {
					temp.next = n.next;
					n = null;
				} else {
					temp = n;
					n = n.next;
				}
			}
		} 
		
		size--;
	}
	
	public void search(int value) {
		Node n = head;
		int i = 0;
		
		while(n.next != null) {
			if(n.value == value) {
				System.out.println("value " + value +" is in index " + i );
				return;
			}
			n = n.next;
			i++;
		}
		System.out.println("value " + value + " is not present in the list .");
	}
	
	public static void main(String[] args) {

		cll.addTop(1);
		cll.addTop(2);
		cll.addTop(3);
		cll.addTop(4);
		cll.addTop(5);
		cll.addTop(6);
		cll.addTop(7);
		cll.addTop(8);
		cll.addTop(9);
		cll.nthNumber(5);
	}
	
	//Interview question. 
	// return the nth element from the last of the list
	private void nthNumber(int nth) {
		int index = size - nth;
		int i = 0;
		Node n = head;
		
		while(i<index) {
			n = n.next;
			i++;
		}
		System.out.println("nth value of the list: " + n.value);
	}
	
	//Interview question.
	// remove the duplicate elements from the list and print them
	public void removeDup() {
		
		Node n1 = head;
		
		for(int i=0; i<size; i++) {
			Node n2 = n1.next;
			for(int j=i+1; j<size; j++) {
				if(n1.value == n2.value) {
					n2 = n2.next;
					deleteMid(j);
					j--;
				} else { 
					n2 = n2.next;
				}
			}
			n1 = n1.next;
		}		
	}
	
	private void status() {
		System.out.println("head: " + cll.head + "\n"
				+ "tail: " + cll.tail + "\n"
				+ "head.value: " + cll.head.value + "\n"
				+ "tail.value: " + cll.tail.value + "\n"
				+ "cll.size: " + cll.size + "\n");
	}

}
