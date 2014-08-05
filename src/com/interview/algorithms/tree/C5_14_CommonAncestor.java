package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTree;
import com.interview.basics.model.tree.BinaryTreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/17/14
 * Time: 3:02 PM
 */
public class C5_14_CommonAncestor {

    public static BinaryTreeNode find(BinaryTree tree, BinaryTreeNode n1, BinaryTreeNode n2){
        if(n1 == n2) return n1;
        else {
            if(n1.height() < n2.height())
                return find(tree, n1.getParent(), n2);
            else if(n1.height() > n2.height())
                return find(tree, n1, n2.getParent());
            else
                return find(tree, n1.getParent(), n2.getParent());
        }
    }

    public static BinaryTreeNode getLCA(BinaryTree tree, BinaryTreeNode n1, BinaryTreeNode n2){
        return getLCA(tree.getRoot(), n1, n2);
    }

    private static BinaryTreeNode getLCA(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2){
        if(root == null) return null;
        if(root == n1 || root == n2) return root;
        BinaryTreeNode left = getLCA(root.getLeftChild(), n1, n2);
        BinaryTreeNode right = getLCA(root.getRightChild(), n1, n2);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}
