package com.interview.algorithms.tree;

import com.interview.basics.model.collection.list.List;
import com.interview.basics.model.tree.BinaryTree;
import com.interview.util.TestUtil;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

public class C5_13_TreeByLayerListTest extends TestCase {

    public void testGetLists() throws Exception {

        Integer[] testArray = TestUtil.generateIntArray(10, 100, 0);

        BinaryTree tree = new BinaryTree(testArray);
        BinaryTreePrinter.print(tree.getRoot());

        List<List> lists = C5_13_TreeByLayerList.getLists(tree);

        assertEquals(4, lists.size());
        assertEquals(1, lists.get(0).size());
        assertTrue(lists.get(0).contains(tree.getRoot()));
        assertEquals(2, lists.get(1).size());
        assertTrue(lists.get(1).contains(tree.getRoot().getLeftChild()));
        assertTrue(lists.get(1).contains(tree.getRoot().getRightChild()));
        assertEquals(4, lists.get(2).size());
        assertEquals(3, lists.get(3).size());
    }
}