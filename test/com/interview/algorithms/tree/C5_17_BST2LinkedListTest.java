package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.model.tree.BinaryTreeNode;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-18
 * Time: 下午8:47
 */
public class C5_17_BST2LinkedListTest extends TestCase {
    public void testTransfer() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        BinaryTreePrinter.print(tree.getRoot());

        MaxMinNode node = C5_17_BST2LinkedList.transfer(tree);

        BinaryTreeNode<Integer> head = node.getMin();
        int count = 1;
        while(head.getRightChild() != null){
            assertTrue(head.getValue().intValue() <= head.getRightChild().getValue().intValue());
            head = head.getRightChild();
            count++;
        }
        assertEquals(11, count);

        BinaryTreeNode<Integer> tail = node.getMax();
        count = 1;
        while(tail.getLeftChild() != null){
            assertTrue(head.getValue().intValue() >= tail.getLeftChild().getValue().intValue());
            tail = tail.getLeftChild();
            count++;
        }
        assertEquals(11, count);
    }
}
