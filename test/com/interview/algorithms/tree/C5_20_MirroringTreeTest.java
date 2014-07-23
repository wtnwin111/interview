package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.model.tree.BinaryTreeNode;
import junit.framework.TestCase;

public class C5_20_MirroringTreeTest extends TestCase {

    public void testMirror() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        C5_20_MirroringTree.mirror(tree);
        assertTrue(check(tree.getRoot()));
    }

    public boolean check(BinaryTreeNode<Integer> node){
        if(node.getLeftChild() != null)
            if(node.getValue().intValue() >= node.getLeftChild().getValue().intValue() || !check(node.getLeftChild()))
                return false;
        if(node.getRightChild() != null)
            if(node.getValue().intValue() <= node.getRightChild().getValue().intValue() || !check(node.getRightChild()))
                return false;
        return true;
    }
}