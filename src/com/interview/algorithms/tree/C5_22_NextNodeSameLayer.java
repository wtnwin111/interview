package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTree;
import com.interview.basics.model.tree.BinaryTreeNode;

/**
 * Created_By: stefanie
 * Date: 14-8-30
 * Time: 下午9:29
 *
 * using parent as the next pointer
 */
public class C5_22_NextNodeSameLayer {

    public static void findNext(BinaryTree tree){
        BinaryTreeNode node = tree.getRoot();
        findNext(node);
    }

    private static void findNext(BinaryTreeNode node){
        if(node.getLeftChild() != null) {
            node.getLeftChild().setParent(node.getRightChild());
            findNext(node.getLeftChild());
        }
        if(node.getRightChild() != null) {
            if (node.getParent() != null) node.getRightChild().setParent(node.getParent().getLeftChild());
            else node.getRightChild().setParent(null);
            findNext(node.getRightChild());
        }

    }
}
