package com.interview.basics.search.array;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.model.tree.BinaryTreeNode;

public class BSTSearcher<T extends Comparable<T>> extends ArraySearcher<T>{
	private BinarySearchTree<T> tree;
	
	public BSTSearcher(T[] input) {
        super(input);
        tree = new BinarySearchTree<T>(input);
    }

	@Override
	public T find(T item) {
        BinaryTreeNode<T> node = tree.search(item);
        return node != null? node.value : null;
	}
}
