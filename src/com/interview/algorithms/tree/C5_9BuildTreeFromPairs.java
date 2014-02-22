package com.interview.algorithms.tree;

import com.interview.datastructures.tree.BinaryTreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created_By: zouzhile
 * Date: 2/21/14
 * Time: 4:15 PM
 */
public class C5_9BuildTreeFromPairs {

    public BinaryTreeNode convert(int[] children, int[] parents) {
        HashMap<Integer, BinaryTreeNode> nodes = new HashMap<>();

        // resolve root
        int rootValue = this.getRootValue(children, parents);
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        nodes.put(rootValue, root);

        for(int i = 0; i < children.length; i ++) {
            int child = children[i];

            BinaryTreeNode childNode = nodes.get(child);
            if(childNode == null) {
                childNode = new BinaryTreeNode(child);
                nodes.put(child, childNode);
            }

            int parent = parents[i];
            BinaryTreeNode parentNode = nodes.get(parent);
            if(parentNode == null) {
                parentNode = new BinaryTreeNode(parent);
                nodes.put(parent, parentNode);
            }
            // set parent child relationship
            childNode.setParent(parentNode);
            if(parentNode.getLeftChild() == null)
                parentNode.setLeftChild(childNode);
            else
                parentNode.setRightChild(childNode);
        }

        return root;
    }



    private int getRootValue(int[] children, int[] parents) {
        HashSet<Integer> ancestors = new HashSet<>();
        for(int parent : parents)
            ancestors.add(parent);
        for(int child : children)
            ancestors.remove(child);
        return ancestors.iterator().next();
    }

    public static void main(String[] args) {
        /*
		System.out.println("            6");
		System.out.println("           / \ ");
		System.out.println("          4   8");
		System.out.println("         / \ / \ ");
		System.out.println("        3  5 7  9");
         */
        int[] children = new int[] {3, 5, 7, 9, 4, 8};
        int[] parents = new int[] {4, 4, 8, 8, 6, 6};
        C5_9BuildTreeFromPairs builder = new C5_9BuildTreeFromPairs();
        BinaryTreeNode root = builder.convert(children, parents);

        System.out.println("Printing the trees ....");
        TreeTraverse traverser = new TreeTraverse();
        traverser.traverseByPreOrder(root);
    }



}
