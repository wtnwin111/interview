package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTree;
import com.interview.basics.model.tree.BinaryTreeNode;
import com.interview.utils.BinaryTreePrinter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-8-30
 * Time: 下午9:37
 */
public class C5_22_NextNodeSameLayerTest extends TestCase {
    public void testFindNext() throws Exception {
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};

        BinaryTree<Integer> tree = new BinaryTree<Integer>(data);
        BinaryTreePrinter.print(tree.getRoot());

        C5_22_NextNodeSameLayer.findNext(tree);

        assertNull(tree.getRoot().getParent());
        BinaryTreeNode<Integer> node = tree.getRoot();
        assertEquals(18, node.getLeftChild().getParent().getValue().intValue());
        assertNull(node.getRightChild().getParent());

        node = node.getLeftChild();
        assertEquals(20, node.getLeftChild().getParent().getValue().intValue());
        assertEquals(3, node.getRightChild().getParent().getValue().intValue());
        node = node.getParent();
        assertEquals(17, node.getLeftChild().getParent().getValue().intValue());
        assertNull(node.getRightChild().getParent());


    }
}
