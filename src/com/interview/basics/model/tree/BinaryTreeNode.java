package com.interview.basics.model.tree;

public class BinaryTreeNode<T> {
	
	private T value;
	private BinaryTreeNode<T> leftChild;
	private BinaryTreeNode<T> rightChild;
	private BinaryTreeNode<T> parent;
    private int size = 1;
    private int height = 1;
	
	public BinaryTreeNode(T value){
		this.value = value;
	}

	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
        if(leftChild != null)
		    leftChild.setParent(this);
	}

	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}

    public int size() {
        return this.size;
    }

    public int height() {
        return this.height;
    }

    public int resize() {
        int leftSubTreeSize = this.getLeftChild() == null ? 0 : this.getLeftChild().resize();
        int rightSubTreeSize = this.getRightChild() == null ? 0 : this.getRightChild().resize();
        this.size = leftSubTreeSize + rightSubTreeSize + 1;
        return this.size;
    }

    public int reheight(){
        int leftHeight = this.getLeftChild() == null ? 0 : this.getLeftChild().reheight();
        int rightHeight = this.getRightChild() == null ? 0 : this.getRightChild().reheight();
        this.height = Math.max(leftHeight, rightHeight) + 1;
        return this.height;
    }

	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
        if(rightChild != null)
		    rightChild.setParent(this);
	}


	public T getValue() {
		return value;
	}

	public void setValue(T value){
		this.value = value;
	}
	public BinaryTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode parent) {
		this.parent = parent;
	}	
	
}
