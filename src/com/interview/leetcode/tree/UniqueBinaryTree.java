package com.interview.leetcode.tree;

import com.interview.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-21
 * Time: 下午5:22
 */

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n
 *
 * Number is a Catalan Sequence.
 *
 */
public class UniqueBinaryTree {

    public int numTrees(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for(int total = 2; total <= n; total++){
            nums[total] = 0;
            for(int left = 0; left < total; left++){
                nums[total] += nums[left] * nums[total - 1 - left]; //total - 1 - left is right
            }
        }
        return nums[n];
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int low, int high){
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if(low > high) {
            trees.add(null);
            return trees;
        }
        for(int value = low; value <= high; value++){      //value as root element
            List<TreeNode> leftTree = generateTrees(low, value - 1);
            List<TreeNode> rightTree = generateTrees(value + 1, high);
            for(TreeNode leftNode : leftTree){
                for(TreeNode rightNode: rightTree){
                    TreeNode root = new TreeNode(value);
                    root.left = leftNode;
                    root.right = rightNode;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
