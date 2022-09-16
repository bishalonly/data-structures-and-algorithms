package tree;

import java.util.Arrays;

public class BinaryTreeArray {
	int[] arr;
	private int lastIndex;
	
	public BinaryTreeArray(int size) {
		arr = new int[size+1];
		lastIndex = 0;
	}
	
	public boolean isFull() {
		return (lastIndex == arr.length - 1);
	}

	public static void main(String[] args) {
		BinaryTreeArray bta = new BinaryTreeArray(9);
		bta.insert(1);
		bta.insert(2);
		bta.insert(3);
		bta.insert(4);
		bta.insert(5);
		bta.insert(6);
		bta.insert(7);
		bta.insert(8);
		bta.insert(9);
		//bta.insert(10);
		bta.print();
//		System.out.print("\n preOrder: ");
//		bta.preOrder(1);
//		System.out.print("\n inOrder: ");
//		bta.inOrder(1);
//		System.out.print("\n postOrder: ");
//		bta.postOrder(1);
//		System.out.print("\n levelOrder: ");
//		bta.levelOrder();
		
		bta.deleteAndReplaceWithLastNode(5);
		bta.levelOrder();
		bta.deleteAndReplaceWithLastNode(9);
		bta.levelOrder();
		bta.deleteAndReplaceWithLastNode(9);
		bta.delete(5);
	}
	
	public void deleteAndReplaceWithLastNode(int num) {
		int last = arr[lastIndex];
		
		for(int i=1; i<=lastIndex; i++) {
			if(arr[i] == num) {
				arr[i] = last;
				System.out.println(num + " is deleted at index " + i + " from the array.");
				lastIndex--;
				return;
			}
		}
		System.out.println(num + " is not present in array.");
	}
	
	public void delete(int num) {
		for(int i=1; i<=lastIndex; i++) {
			if(arr[i] == num) {
				shift(i,arr);
				System.out.println(num + " is deleted at index " + i + " from the array.");
				lastIndex--;
				return;
			}
		}
		
		System.out.println(num + " is not present in array.");
	}
	
	private void shift(int i, int[] arr) {
		for(int j = i; j<lastIndex; j++) {
			arr[j] = arr[j+1];
		}
	}

	public int search(int num) {
		for(int i=1; i<=lastIndex; i++) {
			if(arr[i] == num) {
				System.out.println(num + " is found in array @ index " + i);
				return i;
			}
		}
		
		System.out.println(num + " is not present in array.");
		
		return -1;
	}
	
	public void levelOrder() {
		for(int i=1; i<=lastIndex; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void inOrder(int index) {
		if(index > lastIndex) {
			return;
		}
		
		inOrder(index * 2);
		System.out.print(arr[index] + " ");
		inOrder(index * 2 + 1);		
	}
	
	
	public void preOrder(int index) {
		if(index > lastIndex) {
			return;
		}
		
		System.out.print(arr[index] + " ");
		preOrder(index * 2);
		preOrder(index * 2 + 1);
		
	}
	
	public void postOrder(int index) {
		if(index > lastIndex) {
			return;
		}
		
		postOrder(index * 2);
		postOrder(index * 2 + 1);
		System.out.print(arr[index] + " ");
		
	}
	
	public void insert(int data) {
		if(!isFull()) {
			arr[++lastIndex] = data;
		} else {
			System.out.println("can't add " + data + " as binary tree is full.");
		}
	}
	
	public void print() {
		System.out.println(Arrays.toString(arr));
	}

}
