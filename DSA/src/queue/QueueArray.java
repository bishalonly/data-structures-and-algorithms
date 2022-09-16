package queue;

import java.util.Arrays;

import linkedList.Node;

public class QueueArray {
	
	int[] arr;
	int first;
	int last;
	int size;
	
	public QueueArray(int size) {
		arr = new int[size];
		this.size = size;
		first = -1;
		last = -1;
	}

	public static void main(String[] args) {
		QueueArray qa = new QueueArray(3);
		qa.enQueue(1);
		qa.enQueue(2);
		qa.enQueue(3);
		qa.deQueue();
		qa.deQueue();
		qa.enQueue(4);
		qa.deQueue();
		qa.enQueue(5);
		qa.deQueue();qa.peek();qa.deQueue();
		qa.peek();
		qa.enQueue(1);
		System.out.println(Arrays.toString(qa.arr));
	}
	
	public boolean isFull() {
		if((last == size - 1 && first == 0) || first-1 == last)
			return false;
		return true;
	}
	
	public boolean isEmpty() {
		if(last == -1)
			return true;
		return false;
	}
	
	private  void enQueue(int value) {
		if(isFull()) {
			System.out.println("queue is full");
		}else if(isEmpty()) {
			first = 0;
			last = 0;
			arr[last] = value;
		}else if(first !=0 && last == size-1) {
			last = 0;
			arr[last] = value;
		} else {
			last++;
			arr[last] = value;
		}
		
	}
	
	private int deQueue() {
		if(last ==-1 && first == -1 ) {
			System.out.println("Queue is empty");
			return -1;
		} else if(first == size-1){
			int ans = arr[first];
			arr[first] = -1;
			first =0;
			return ans;
		} else {
			int ans = arr[first];
			arr[first] = -1;
			first++;
			return ans;
		}
	}
	
	private void peek() {
		if(first == -1) {
			System.out.println("queue is empty");
		} else {
			System.out.println("Q1 elemt in queue is: " + arr[first]);
		}
	}
	

}
