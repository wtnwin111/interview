package com.interview.algorithms.tree;

import com.interview.basics.model.collection.list.ArrayList;
import com.interview.basics.model.collection.list.List;
import com.interview.basics.model.tree.BinaryTree;

import java.util.Iterator;

/**
 * Created_By: stefanie
 * Date: 14-7-16
 * Time: 下午10:14
 */

public class C5_5_BSTProver<T extends Comparable> {

    public boolean isBST(BinaryTree<T> tree){
        AddListProcessor p = new AddListProcessor();
        C5_1_TreeTraverse.traverseByInOrder(tree.getRoot(), p);
        Iterator<T> itr = p.list.iterator();
        T current = itr.next();
        while(itr.hasNext()){
            if(current.compareTo(itr.next()) > 0) return false;
        }
        return true;
    }
}
