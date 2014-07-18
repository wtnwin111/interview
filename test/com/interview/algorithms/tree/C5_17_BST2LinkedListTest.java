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

        BinaryTreeNode<Integer> node = C5_17_BST2LinkedList.transfer(tree);
        System.out.println(node.getValue().intValue());

        int count = 1;
        while(node.getRightChild() != null){
            System.out.println(node.getRightChild().getValue().intValue());
            assertTrue(node.getValue().intValue() <= node.getRightChild().getValue().intValue());
            node = node.getRightChild();
            count++;
        }
        assertEquals(11, count);
    }
}
