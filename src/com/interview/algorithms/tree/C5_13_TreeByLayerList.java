package com.interview.algorithms.tree;

import com.interview.basics.model.collection.list.ArrayList;
import com.interview.basics.model.collection.list.List;
import com.interview.basics.model.tree.BinaryTree;
import com.interview.basics.model.tree.BinaryTreeNode;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/17/14
 * Time: 1:13 PM
 */
public class C5_13_TreeByLayerList {

    public static List<List> getLists(BinaryTree tree){
        List<List> lists = new ArrayList<List>();

        List<BinaryTreeNode> current;
        List<BinaryTreeNode> children = new ArrayList<>();
        children.add(tree.getRoot());

        while(children.size() > 0){
            lists.add(children);
            current = children;
            children = new ArrayList<>();
            Iterator<BinaryTreeNode> itr = current.iterator();
            while(itr.hasNext()){
                BinaryTreeNode node = itr.next();
                if(node.getLeftChild() != null) children.add(node.getLeftChild());
                if(node.getRightChild() != null) children.add(node.getRightChild());
            }
        }
        return lists;

    }
}
