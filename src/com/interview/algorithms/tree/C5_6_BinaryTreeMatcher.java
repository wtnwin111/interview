package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTree;
import com.interview.basics.model.tree.BinaryTreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/17/14
 * Time: 9:04 AM
 */
public class C5_6_BinaryTreeMatcher {

    public static boolean equals(BinaryTree t1, BinaryTree t2){
        return equals(t1.getRoot(), t2.getRoot());
    }

    public static boolean equals(BinaryTreeNode n1, BinaryTreeNode n2){
        if(n1 == null && n2 == null) return true;
        if(n1 != null && n2 != null && n1.getValue().equals(n2.getValue()) && n1.size() == n2.size()){
            boolean leftEquals = equals(n1.getLeftChild(), n2.getLeftChild());
            boolean rightEquals = equals(n1.getRightChild(), n2.getRightChild());
            return leftEquals && rightEquals;
        }
        return false;
    }
}
