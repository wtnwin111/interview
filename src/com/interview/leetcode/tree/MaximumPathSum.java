package com.interview.leetcode.tree;

import com.interview.leetcode.utils.TreeNode;

/**
 * Created_By: stefanie
 * Date: 14-11-13
 * Time: 下午3:10
 *
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
 * For example: Given the below binary tree,
 *      1
 *     / \
 *    2   3
 *  Return 6.
 *
 * Solutions:
 * The max path should have following 4 cases:
 *      i. max(left subtree) + node
 *      ii. max(right subtree) + node
 *      iii. max(left subtree) + max(right subtree) + node
 *      iv. the node itself  (!!!!important)
 * The path of root is depends on both left and right subtree, should use post-order traverse.
 * It's a standard divide and conquer sample for Tree, in post-order traverse.
 *
 * Tricks:
 *  1. Define a simplest and clear calculation method for the variable you interested (max path), may have several different cases.
 *  2. For tree problem, find a suitable traverse: pre-order, in-order and post-order.
 *  3. Using divide and conquer every TreeNode, do the same procedure on its children.
 *  4. Consider the cases if result go negative, do we need change it to 0.    for the singlePath
 */
public class MaximumPathSum {
    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        visitTree(root);
        return maxSum;
    }

    public int visitTree(TreeNode node){
        if(node == null) return 0;
        //Divide
        int left = visitTree(node.left);
        int right = visitTree(node.right);
        //Conquer
        maxSum = Math.max(maxSum, left + right + node.val);
        int singleMax = Math.max(left, right) + node.val;
        return singleMax > 0? singleMax : 0;
    }
}
