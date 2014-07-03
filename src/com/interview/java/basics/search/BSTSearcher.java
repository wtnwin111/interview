package com.interview.java.basics.search;

public class BSTSearcher extends Searcher{
	private BSTNode root;
	
	class BSTNode {
		public int index;
		public int value;
		public BSTNode left;
		public BSTNode right;
		
		public BSTNode(int index, int value){
			this.index = index;
			this.value = value;
		}
	}
	
	public BSTSearcher(int[] input) {
		super(input);
		for(int i = 0; i < input.length; i++){
			root = addNode(root, i);
		}
	}
	
	protected BSTNode addNode(BSTNode node, int index){
		if(node == null){
			return new BSTNode(index, input[index]);
		} else {
			if(node.value < input[index]){
				node.right = addNode(node.right, index);
			} else {
				node.left = addNode(node.left, index);
			}
			return node;
		}
	}

	@Override
	public int search(int item) {
		BSTNode node = root;
		while(node != null){
			if(node.value == item)		return node.index;
			else if(node.value > item)	node = node.left;
			else 						node = node.right;
		}
		return -1;
	}
	
	
}
