package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.model.tree.BinaryTreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/17/14
 * Time: 11:00 AM
 */
public class C5_11_MiniBinarySearchTree<T extends Comparable> {
    public BinarySearchTree<T> create(T[] elements){
        BinaryTreeNode root = createTree(elements, 0, elements.length - 1);

        return new BinarySearchTree<T>(root);
    }

    private BinaryTreeNode<T> createTree(T[] elements, int start, int end){
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        BinaryTreeNode<T> node = new BinaryTreeNode<>(elements[mid]);
        node.setLeftChild(createTree(elements, start, mid - 1));
        node.setRightChild(createTree(elements, mid + 1, end));
        return node;
    }
}
