package com.interview.datastructures.tree;

public class BinaryTreeNode {
	
	private int value;
	private BinaryTreeNode leftChild;
	private BinaryTreeNode rightChild;
	private BinaryTreeNode parent;
    private int size;
	
	public BinaryTreeNode(int value){
		this.value = value;
	}

	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
        if(leftChild != null)
		    leftChild.setParent(this);
	}

	public BinaryTreeNode getRightChild() {
		return rightChild;
	}

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
        if(rightChild != null)
		    rightChild.setParent(this);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value){
		this.value = value;
	}
	public BinaryTreeNode getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode parent) {
		this.parent = parent;
	}	
	
}
