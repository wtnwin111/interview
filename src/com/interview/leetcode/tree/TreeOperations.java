package com.interview.leetcode.tree;

import com.interview.leetcode.utils.TreeNode;

/**
 * Created_By: stefanie
 * Date: 14-11-17
 * Time: 下午3:03
 */
public class TreeOperations {
    public static TreeNode upsideDown(TreeNode root) {
        TreeNode fakeRoot = new TreeNode(0);
        fakeRoot.left = root;
        root = upsideDown(root, fakeRoot);
        root.right = null;
        root.left = null;
        return fakeRoot.right;
    }

    private static TreeNode upsideDown(TreeNode node, TreeNode prev){
        if(node == null) return prev;
        if(node.left == null){
            prev.right = node;
            return node;
        }
        prev = upsideDown(node.left, prev);
        prev.right = node;
        prev.left = node.right;
        return node;
    }
}
