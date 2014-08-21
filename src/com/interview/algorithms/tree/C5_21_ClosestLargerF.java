package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.model.tree.BinaryTreeNode;

/**
 * Created_By: stefanie
 * Date: 14-8-21
 * Time: 上午10:43
 */
public class C5_21_ClosestLargerF {
    public static int find(BinarySearchTree<Integer> tree){
        int f = getF(tree);
        BinaryTreeNode<Integer> node = find(tree, tree.getRoot(), f);
        return node.getValue();
    }

    public static BinaryTreeNode find(BinarySearchTree<Integer> tree, BinaryTreeNode<Integer> node, int key){
        if(node.getValue() == key) return tree.successor(node);
        else if(node.getValue() < key && node.getRightChild() != null) return find(tree, node.getRightChild(), key);
        else if(node.getValue() > key){
            if(node.getLeftChild() != null) {
                BinaryTreeNode n = find(tree, node.getLeftChild(), key);
                return n == null? node: n;
            } else {
                return node;
            }
        }
        return null;
    }

    public static int getF(BinarySearchTree<Integer> tree){
        BinaryTreeNode<Integer> node = tree.getRoot();
        while(node.getLeftChild() != null) node = node.getLeftChild();
        int smallest = node.getValue();

        node = tree.getRoot();
        while(node.getRightChild() != null) node = node.getRightChild();
        int largest = node.getValue();

        return (smallest + largest) / 2;
    }
}
