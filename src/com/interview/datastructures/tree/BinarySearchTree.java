package com.interview.datastructures.tree;

import com.interview.utils.BinaryTreePrinter;

public class BinarySearchTree {

	private BinaryTreeNode root;
	
	public BinarySearchTree(int[] nodeValues){
		this.root = new BinaryTreeNode(nodeValues[0]);
		for(int i = 1; i< nodeValues.length; i ++){
			insert(nodeValues[i]);
		}
	}

    public BinaryTreeNode getRoot(){
        return this.root;
    }

    /**
     * Insert the new node as a leaf node.
      * @param newValue
     */
	public void insert(int newValue){
		BinaryTreeNode node = root;
		boolean stop = false;
        // The while loop looks up the right leaf node position for the new node.
		while(!stop){
			if (newValue <= node.getValue()){
				if (node.getLeftChild() == null){
					BinaryTreeNode newNode = new BinaryTreeNode(newValue);
					node.setLeftChild(newNode);
					newNode.setParent(node);
					stop = true;
				} else {
					node = node.getLeftChild();
				}
			} else {
				if (node.getRightChild() == null){
					BinaryTreeNode newNode = new BinaryTreeNode(newValue);
					node.setRightChild(new BinaryTreeNode(newValue)); 
					newNode.setParent(node);
					stop = true;
				} else {
					node = node.getRightChild();
				}				
			}
		}
	}
	
	public void delete(BinaryTreeNode node){	
		if (node == null){
			return;
		}
		BinaryTreeNode parent = node.getParent();
		
		if(node.getLeftChild() == null && node.getRightChild() == null){ 
			// The given node is a leaf node
			if (parent == null) {
				this.root = null;
				return;
			} 
			if (node == parent.getLeftChild()){
				parent.setLeftChild(null);
			} else if (node == parent.getRightChild()){
				parent.setRightChild(null);
			}		
		} else if (node.getLeftChild() == null && ! (node.getRightChild() == null)){
			// the given node only has right child
			BinaryTreeNode rightChild = node.getRightChild();
			node.setValue(rightChild.getValue());
			this.delete(rightChild);
		} else if (!(node.getLeftChild() == null) && node.getRightChild() == null){
			// the given node only has left child
			BinaryTreeNode leftChild = node.getLeftChild();
			node.setValue(leftChild.getValue());
			this.delete(leftChild);
		} else {
			// the given node has both left and right child
			// replace node with its direct successor
			BinaryTreeNode successor = this.successor(node);
			node.setValue(successor.getValue());
			this.delete(successor);
		}
	}
	
	public BinaryTreeNode search(int value){
		BinaryTreeNode node = this.root;
		while (node != null) {
			if (node.getValue() == value){
				break;
			} else if (value < node.getValue()){
				node = node.getLeftChild();
			} else {
				node = node.getRightChild();
			}
		}
		return node;
	}

    public boolean isEmpty(){
        return this.root == null;
    }

    public BinaryTreeNode maximum(){
        if(this.isEmpty())
            return null;
        BinaryTreeNode maximum = this.getRoot();
        while(maximum.getRightChild() != null)
            maximum = maximum.getRightChild();
        return maximum;
    }

    public BinaryTreeNode minimum() {
        if(this.isEmpty())
            return null;
        BinaryTreeNode minimum = this.getRoot();
        while(minimum.getLeftChild() != null)
            minimum = minimum.getLeftChild();
        return minimum;
    }

    /**
     *
     * @param node
     * @return  The direct successor of the given node. Return null if not exist.
     */
    public BinaryTreeNode successor(BinaryTreeNode node) {
        if(node == null)
            return null;
        if(node.getRightChild() != null)
            return node.getRightChild();

        BinaryTreeNode parent = node.getParent();
        while(parent != null && parent.getRightChild() == node) {
            node = parent;
            parent = node.getParent();
        }
        return parent;
    }

    /**
     *
     * @param node
     * @return The direct predecessor of the given node. Return null if not exist.
     */
    public BinaryTreeNode predecessor(BinaryTreeNode node) {
        if(node == null)
            return null;
        if(node.getLeftChild() != null)
            return node.getLeftChild();
        BinaryTreeNode parent = node.getParent();
        while(parent != null && parent.getLeftChild() == node){
            node = parent;
            parent = node.getParent();
        }
        return parent;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("** Binary Search Tree **");
        int[] data = new int[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};

        BinarySearchTree tree = new BinarySearchTree(data);
        System.out.println("The binary tree is below: \n -------------");
        BinaryTreePrinter.print(tree.getRoot());
        System.out.println("--------------------");
        System.out.println("Max: " + tree.maximum().getValue());
        System.out.println("Min: " + tree.minimum().getValue());

        System.out.println("Target Node : 7 ");
        BinaryTreeNode target = tree.search(7);
        System.out.println("Found node (value = 7) ? : " + (target != null));
        if(target != null) {
            System.out.println("Successor: " + (tree.successor(target) == null ? "Not Exist" : tree.successor(target).getValue()));
            System.out.println("Predecessor: " + (tree.predecessor(target) == null ? "Not Exist" : tree.predecessor(target).getValue()));
        }

        System.out.println("Inserting a node 8 \n ------------ " );
        tree.insert(8);
        BinaryTreePrinter.print(tree.getRoot());

        System.out.println("Deleting the node 6 \n ------------");
        BinaryTreeNode node = tree.search(6);
        tree.delete(node);
        BinaryTreePrinter.print(tree.getRoot());
    }
}
