package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.model.tree.BinaryTreeNode;

/**
 * Created_By: zouzhile
 * Date: 2/16/14
 * Time: 11:12 AM
 *
 * Given a binary search tree, find the Kth largest value.
 */
public class C5_8_KthNodeFinder {

    public BinaryTreeNode find(BinarySearchTree tree, int k){
        return tree.select(k);
    }

}
