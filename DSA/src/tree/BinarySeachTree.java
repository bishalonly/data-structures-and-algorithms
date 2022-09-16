package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * breadth for search (BFS) -> preoder, inorder & postorder
deapth for search (DFS)  -> levelorder

*/

public class BinarySeachTree {

	public BNode root;
	
	public BinarySeachTree() {
		root = null;
	}
	
	public static void main(String[] args) {
		BinarySeachTree bst = new BinarySeachTree();
		BNode n1 = new BNode("N1");
		BNode n2 = new BNode("N2");
		BNode n3 = new BNode("N3");
		BNode n4 = new BNode("N4");
		BNode n5 = new BNode("N5");
		BNode n6 = new BNode("N6");
		BNode n7 = new BNode("N7");
		BNode n8 = new BNode("N8");
		BNode n9 = new BNode("N9");
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.right = n9;
		n4.left = n8;
		n3.left = n6;
		n3.right = n7;
		bst.root = n1;
		
//		bst.preOrder(bst.root);
//		System.out.println("\n");
//		
//		bst.inOrder(bst.root);
//		System.out.println("\n");
//		
//		bst.postOrder(bst.root);
//		System.out.println("\n");
		
//		bst.insert("N0");
//		bst.levelOrder();
		
		bst.delete("N1");
		bst.levelOrder();
		bst.delete("N4");
		bst.delete("N7");
		bst.levelOrder();
	}
	
	public void preOrder(BNode node) {
		if(node == null) return;
		
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder(BNode node) {
		if(node == null) return;
		
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}
	
	public void postOrder(BNode node) {
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+ " ");
	}
	
	public void levelOrder() {
		Queue<BNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			BNode current = queue.remove();
			System.out.print(current.data+" ");
			
			if(current.left != null)
				queue.add(current.left);
			
			if(current.right != null)
				queue.add(current.right);
		}
	}
	
	public void search(String data) {
		Queue<BNode> queue = new LinkedList<>();
		queue.add(root);
	
		while(!queue.isEmpty() ) {
			BNode node = queue.remove();
			
			if(node.data.equalsIgnoreCase(data)) {
				System.out.println(data + " value is found in the tree.");
				return;
			}
			
			if(node.left != null)
				queue.add(node.left);
			
			if(node.left != null)
				queue.add(node.right);
		}
		
		System.out.println(data+ " value is not present in the tree.");
	}
	
	public void insert(String data) {
		BNode node = new BNode(data);
		
		if(root == null) {
			root = node;
			System.out.println(data + " node is created as root.");
		}
		
		Queue<BNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			BNode current = queue.remove();
			
			if(current.left == null) {
				current.left = node;
				System.out.println(data + " node is inserted.");
				return;
			} else if(current.right == null) {
				current.right = node;
				System.out.println(data + " node is inserted.");
				return;
			} else {
				queue.add(current.left);
				queue.add(current.right);
			}
		}
	}
	
	public BNode depestNode() {
		Queue<BNode> queue = new LinkedList<>();
		queue.add(root);
		BNode node = null;
		
		while(!queue.isEmpty()) {
			 node = queue.remove();
			
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
		}
		
		return node;
	}
	
	public void deleteDepestNode() {
		Queue<BNode> queue = new LinkedList<>();
		queue.add(root);
		BNode previousNode, currentNode = null;
		
		while(!queue.isEmpty()) {
			previousNode = currentNode;
			 currentNode = queue.remove();
			 
			 if(currentNode.left == null) {
				 previousNode.right = null;
				 return;
			 } else if(currentNode.right == null) {
				 currentNode.left = null;
				 return;
			 } else {
					if(currentNode.left != null)
						queue.add(currentNode.left);
					if(currentNode.right != null)
						queue.add(currentNode.right);
			 }
		}
		
	}
	
	public void delete(String data) {
		Queue<BNode> queue = new LinkedList<>();
		queue.add(root);
		BNode node = null;
		
		while(!queue.isEmpty()) {
			 node = queue.remove();
			 
			 if(node.data.equals(data)) {
				 node.data = depestNode().data;
				 deleteDepestNode();
				 System.out.println(data+" value has been deleted from the tree.");
				 return;
			 } else {
				 if(node.left != null)
						queue.add(node.left);
					if(node.right != null)
						queue.add(node.right);
			 }
			
		}
		
		System.out.println(data+" value is not present in the tree.");
	}

}

class BNode { // binary node
	public String data;
	public BNode left;
	public BNode right;
	public int height;
	
	public BNode(String data) {
		this.data = data;
	}
		
}
