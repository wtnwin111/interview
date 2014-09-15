package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTreeNode;
import com.interview.utils.BinaryTreePrinter;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 9/15/14
 * Time: 4:52 PM
 */
public class C5_8_BuildPostOrder {
    static class Counter{
        public int offset = 0;
    }
    public static String find(String preOrder, String inOrder){
        Counter co = new Counter();
        BinaryTreeNode<Character> root = buildTree(preOrder, inOrder, co);
        BinaryTreePrinter.print(root);
        final StringBuilder builder = new StringBuilder();
        C5_1_TreeTraverse.traverseByPostOrder(root, new Processor<Character>() {
            @Override
            public void process(Character element) {
                builder.append(element);
            }
        });
        return builder.toString();
    }

    public static BinaryTreeNode<Character> buildTree(String preOrder, String inOrder, Counter co){
        char root = preOrder.charAt(co.offset);
        int index = inOrder.indexOf(root);

        BinaryTreeNode<Character> node = new BinaryTreeNode<>(root);
        if(index > 0) {
            co.offset++;
            node.setLeftChild(buildTree(preOrder, inOrder.substring(0, index), co));
        }
        if(index < inOrder.length() - 1) {
            co.offset++;
            node.setRightChild(buildTree(preOrder, inOrder.substring(index + 1), co));
        }
        return node;
    }
}
