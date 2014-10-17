package com.interview.basics.search.array;

public class BSTSearcher<T extends Comparable<T>> extends ArraySearcher<T>{
	private BSTNode<T> root;

    class BSTNode<T> {
		public int index;
		public T value;
		public BSTNode left;
		public BSTNode right;
		
		public BSTNode(int index, T value){
			this.index = index;
			this.value = value;
		}
	}
	
	public BSTSearcher(T[] input) {
		super(input);
		for(int i = 0; i < input.length; i++){
			root = addNode(root, i);
		}
	}
	
	protected BSTNode<T> addNode(BSTNode<T> node, int index){
		if(node == null){
			return new BSTNode(index, input[index]);
		} else {
			if(node.value.compareTo(input[index]) < 0){
				node.right = addNode(node.right, index);
			} else {
				node.left = addNode(node.left, index);
			}
			return node;
		}
	}

	@Override
	public T find(T item) {
		BSTNode<T> node = root;
		while(node != null){
			if(node.value == item)		return node.value;
			else if(node.value.compareTo(item) > 0)	node = node.left;
			else 						node = node.right;
		}
		return null;
	}

    public int findIndex(T item) {
        BSTNode<T> node = root;
        while(node != null){
            if(node.value == item)		return node.index;
            else if(node.value.compareTo(item) > 0)	node = node.left;
            else 						node = node.right;
        }
        return -1;
    }
}
