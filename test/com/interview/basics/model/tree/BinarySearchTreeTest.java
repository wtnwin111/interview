package com.interview.basics.model.tree;

import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

public class BinarySearchTreeTest extends TestCase {

    public void testMaxMinSize(){
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        tree.resize();

        assertEquals(20, tree.maximum().getValue());
        assertEquals(2, tree.minimum().getValue());
        assertEquals(11, tree.size());
    }

    public void testSearch(){
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        BinaryTreeNode target = tree.search(7);
        assertNotNull(target);
        assertEquals(9, tree.successor(target).getValue());
        assertEquals(6, tree.predecessor(target).getValue());
        assertNull(tree.successor(tree.search(20)));
        assertNull(tree.predecessor(tree.search(2)));
    }

    public void testInsertDelete(){
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        assertNull(tree.search(8));
        tree.insert(8);
        assertNotNull(tree.search(8));

        BinaryTreeNode target = tree.search(6);
        assertNotNull(target);
        tree.delete(target);
        assertNull(tree.search(6));
        BinaryTreePrinter.print(tree.getRoot());
        target = tree.search(7);
        assertEquals(8, tree.successor(target).getValue());
        assertEquals(4, tree.predecessor(target).getValue());
    }

    public void testSelectRank(){
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        tree.resize();
        //BinaryTreePrinter.print(tree.getRoot());
        assertEquals(13, tree.select(7).getValue());
        assertEquals(4, tree.rank(tree.search(18)));
    }
}