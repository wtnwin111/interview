package com.interview.algorithms.tree;

import com.interview.basics.model.collection.queue.LinkedQueue;
import com.interview.basics.model.collection.queue.Queue;
import com.interview.basics.model.tree.BinaryTree;
import com.interview.basics.model.tree.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


/**
 * Created_By: stefanie
 * Date: 14-9-26
 * Time: 下午3:37
 */
public class C5_25_PrintBinaryTreeLayer {
    public static void print(BinaryTreeNode tree){
        Queue<BinaryTreeNode> queue = new LinkedQueue<>();
        queue.push(tree);
        queue.push(null);
        while(!queue.isEmpty()){
            BinaryTreeNode obj = queue.pop();
            if(obj == null){
                if(queue.size() > 0) {
                    queue.push(null);
                    System.out.println();
                    continue;
                } else return;
            }
            System.out.printf("%s  ", obj.getValue().toString());
            if(obj.getLeftChild() != null)  queue.push(obj.getLeftChild());
            if(obj.getRightChild() != null) queue.push(obj.getRightChild());
        }
    }

    public static List<Object> printRecursive(BinaryTreeNode node, int n){
        List<Object> objs = new ArrayList<>();
        printRecursive(node, n, objs);
        return objs;
    }

    private static void printRecursive(BinaryTreeNode node, int n, List<Object> objs){
        if(node == null || n < 0)   return;
        if(n == 0){
            objs.add(node.getValue());
        } else {
            if(node.getLeftChild() != null)  printRecursive(node.getLeftChild(), n - 1, objs);
            if(node.getRightChild() != null) printRecursive(node.getRightChild(), n - 1, objs);
        }
    }

    public static List<Object> print(BinaryTreeNode tree, int n){
        List<Object> objs = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedQueue<>();
        queue.push(tree);
        queue.push(null);
        while(n > 0 && !queue.isEmpty()){
            BinaryTreeNode obj = queue.pop();
            if(obj == null){
                if(queue.size() > 0) {
                    queue.push(null);
                    n--;
                    continue;
                } else return objs;
            }
            //System.out.printf("%s  ", obj.getValue().toString());
            if(obj.getLeftChild() != null)  queue.push(obj.getLeftChild());
            if(obj.getRightChild() != null) queue.push(obj.getRightChild());
        }

        while(!queue.isEmpty()) {
            if(queue.peek() == null) break;
            objs.add(queue.pop().getValue());
        }
        return objs;
    }
}
