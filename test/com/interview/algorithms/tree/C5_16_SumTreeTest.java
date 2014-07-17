package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTree;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

public class C5_16_SumTreeTest extends TestCase {

    public void testFindSum() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinaryTree<Integer> tree = new BinaryTree<Integer>(data);
        BinaryTreePrinter.print(tree.getRoot());

        C5_16_SumTree.findSum(tree, 13);
    }
}