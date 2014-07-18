package com.interview.algorithms.tree;

import com.interview.basics.model.collection.list.List;
import com.interview.basics.model.tree.BinaryTree;
import com.interview.basics.model.tree.BinaryTreeNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/17/14
 * Time: 3:27 PM
 */
public class C5_16_TreeSumPath {

    public static void findSum(BinaryTree<Integer> tree, int sum){
        findSum(tree.getRoot(), sum, new ArrayList<Integer>(), 0);
    }

    private static void findSum(BinaryTreeNode<Integer> head, int sum, ArrayList<Integer> buffer, int level) {
        if (head == null) return;
        int tmp = sum;
        buffer.add(head.getValue().intValue());

        for (int i = level;i >- 1; i--){
            tmp -= buffer.get(i);
            if (tmp == 0) print(buffer, i, level);
        }
        ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
        ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
        findSum(head.getLeftChild(), sum, c1, level + 1);
        findSum(head.getRightChild(), sum, c2, level + 1);
    }
    private static void print(ArrayList<Integer> buffer, int level, int i2) {
        for (int i = level; i <= i2; i++) {
            System.out.print(buffer.get(i) + " ");
        }
        System.out.println();
    }
}
