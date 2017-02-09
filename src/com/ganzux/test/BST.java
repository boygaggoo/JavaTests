package com.ganzux.test;

public class BST {
	
	private static Node root;
	
	public static void main(String[] args){
		BST bst = new BST();
		
		bst.add(0);
		bst.add(30);
		bst.add(20);
		bst.add(-10);
		bst.add(9);
		bst.add(10);
		bst.add(35);
		bst.add(32);
		bst.add(5);
		bst.add(7);
		bst.add(37);
		bst.add(-20);
		
		/*					0
		 * 		-10						  30
		 * 	-20					20					35
		 * 					9					32
		 * 				5		10
		 * 					7
		 */

		System.out.println("IN");
		getInOrder(root);
		
		System.out.println("LCA of 5 and 7 is 5?: " + getLeastComonAncestor(root, 5, 7).value);
		System.out.println("LCA of -20 and 10 is 0?: " + getLeastComonAncestor(root, -20, 10).value);
		System.out.println("LCA of 20 and 35 is 30?: " + getLeastComonAncestor(root, 20, 35).value);
		
		Node nodeToFind = find(7, root);
		
		remove(7, root, null);
		System.out.println("No 7");
		getInOrder(root);
		bst.add(7);
		remove(20, root, null);
		System.out.println("No 20");
		getInOrder(root);
		bst.add(20);
		remove(30, root, null);
		System.out.println("No 30");
		getInOrder(root);
	}

	public boolean add(int value) {
        if (root == null) {
              root = new Node(value);
              return true;
        } else
              return root.add(value);
	}
	
	public static void remove(int nodeValue, Node parent, Node node){

		// Root safety check
		if (node == null){
			node = parent;
		}

		// This is the node
		if (nodeValue == node.getValue()){

			// Base case, leaf
			if (node.getLeft() == null && node.getRight() == null){
				if (parent.getValue() < nodeValue){
					parent.setRight(null);
				} else {
					parent.setLeft(null);
				}
				node = null;
				return;
			}

			// Base case, just 1 child, the right one
			else if (node.getLeft() == null){
				if (parent.getValue() < nodeValue){
					parent.setRight(node.getRight());
				} else {
					parent.setLeft(node.getRight());
				}
				return;
			}
			// Base case, just 1 child, the left one
			else if (node.getRight() == null){
				if (parent.getValue() < nodeValue){
					parent.setRight(node.getLeft());
				} else {
					parent.setLeft(node.getLeft());
				}
				return;
			}
			
			// Last case, 2 children
			else{
				// To remove a node with 2 children, we have to find the lowest
				// value from the right side
				Node rightMin = node.getMin(parent.getRight());
				// we remove the node (it will be a base case 1 or 2)
				remove(rightMin.getValue(), node, node);
				// and we replace the value we are removing for the previous one
				node.setValue(rightMin.getValue());
			}
		}
		
		// Recursion, inspect the tree; the parent will be the actual node
		// and depending on the value, we inspect either the right or the left
		else if (nodeValue < parent.value){
			remove(nodeValue, node, parent.getLeft());
		} else if (nodeValue > parent.value){
			remove(nodeValue, node, parent.getRight());
		}
		
			
	}
	
	public static void getPreOrder(Node node){
		if (node != null){
			System.out.println(node.getValue());
			getPreOrder(node.getLeft());
			getPreOrder(node.getRight());
		}
	}
	
	public static void getPostOrder(Node node){
		if (node != null){
			getPostOrder(node.getLeft());
			getPostOrder(node.getRight());
			System.out.println(node.getValue());
		}
	}
	
	public static void getInOrder(Node node){
		if (node != null){
			getInOrder(node.getLeft());
			System.out.println(node.getValue());
			getInOrder(node.getRight());
		}
	}

	public static Node getLeastComonAncestor(Node node, int value1, int value2){
		if (node == null){
            return null;
		}

		int nodeValue = node.value;
  
        // If both n1 and n2 are smaller than the node, then LCA lies in left
        if (nodeValue > value1 && nodeValue > value2){
            return getLeastComonAncestor(node.left, value1, value2);
        }
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (nodeValue < value1 && nodeValue < value2){
            return getLeastComonAncestor(node.right, value1, value2);
        }

        // In this case, the
        return node;
	}
	
	public static Node find(int valueToFind, Node position){

		if (position == null || position.value == null) {
			return null;
		}

		else if (position.value == valueToFind){
			return position;
		}

		// LEFT
		else if (valueToFind < position.value) {
			return find(valueToFind, position.getLeft());
		}

		// RIGHT
		else if (valueToFind > position.value) {
			return find(valueToFind, position.getRight());
		}

		// There is no Node
		return null;
	}

	public class Node {

		private Integer value = null;
		private Node left;
		private Node right;


		public boolean add(int valueToAdd) {
			if (valueToAdd == value){
				return false;
			}
			
			// LEFT
			else if (valueToAdd < value) {
				if (left == null) {
					left = new Node(valueToAdd);
					return true;
				} else {
					return left.add(valueToAdd);
				}
			}
			
			// RIGHT
			else if (valueToAdd > value) {
				if (right == null) {
					right = new Node(valueToAdd);
					return true;
				} else {
					return right.add(valueToAdd);
				}
			}
			return false;
		}

		private Node getMin(Node node){
			if (node.getLeft() != null){
				return getMin(node.getLeft());
			} else {
				return node;
			}
		}
		
		public Node(Integer value){
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
	}
}
