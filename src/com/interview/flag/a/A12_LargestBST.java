package com.interview.flag.a;

import com.interview.basics.model.collection.hash.HashMap;
import com.interview.leetcode.utils.TreeNode;

/**
 * Created_By: stefanie
 * Date: 14-12-4
 * Time: 下午9:38
 */
public class A12_LargestBST {
    static TreeNode lastVisited = null;
    static int max = 0;

    public static int largest(TreeNode root) {
        lastVisited = null;
        max = 0;
        BSTSize(root);
        return max;
    }

    public static int BSTSize(TreeNode node) {
        if (node == null) return 0;
        int left = BSTSize(node.left);
        boolean leftNotBST = node.left != null && left == 0;
        boolean curNotBST = lastVisited != null && lastVisited.val > node.val;
        if (leftNotBST || curNotBST) {   //left subtree is not a BST
            lastVisited = null;
            BSTSize(node.right);
            return 0;
        } else {
            lastVisited = node;
            int right = BSTSize(node.right);
            if (node.right != null && right == 0) return 0;
            max = Math.max(max, left + right + 1);
            return left + right + 1;
        }

    }

    public static void main(String[] args) {
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            nodes.put(i, new TreeNode(i));
        }
        nodes.get(5).left = nodes.get(2);
        nodes.get(5).right = nodes.get(4);
        nodes.get(2).left = nodes.get(1);
        nodes.get(2).right = nodes.get(3);

        TreeNode root = nodes.get(5);
        //3
        System.out.println(largest(root));
    }
}
