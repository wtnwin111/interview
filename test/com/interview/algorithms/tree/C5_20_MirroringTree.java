package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTree;
import com.interview.basics.model.tree.BinaryTreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/22/14
 * Time: 4:53 PM
 */
public class C5_20_MirroringTree {

    public static void mirror(BinaryTree tree){
        mirror(tree.getRoot());
    }

    public static void mirror(BinaryTreeNode node){
        BinaryTreeNode tmp = node.getLeftChild();
        node.setLeftChild(node.getRightChild());
        node.setRightChild(tmp);

        if(node.getLeftChild() != null) mirror(node.getLeftChild());
        if(node.getRightChild() != null) mirror(node.getRightChild());
    }
}
