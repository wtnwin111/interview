package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTree;
import com.interview.basics.model.tree.BinaryTreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/22/14
 * Time: 3:20 PM
 */
public class C5_19_MaxDistance {

    public static int distance(BinaryTree tree){
        tree.reheight();
        return distance(tree.getRoot());
    }

    public static int distance(BinaryTreeNode node){
        if(node == null || node.getLeftChild() == null && node.getRightChild() == null) return 0;
        if(node == null) return 0;
        int leftDistance = distance(node.getLeftChild());
        int rightDistance = distance(node.getRightChild());
        int count = 0;
        if(node.getLeftChild() != null) count += node.getLeftChild().height();
        if(node.getRightChild() != null) count += node.getRightChild().height();
        return Math.max(Math.max(leftDistance, rightDistance), count);
    }
}
