package com.interview.leetcode.tree;

import com.interview.leetcode.utils.ListNode;
import com.interview.leetcode.utils.TreeNode;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 上午8:27
 */
public class TreeConstruction {

    /**
     * given a sorted array, create a balanced BST
     */
    static class SortedArrayBuilder {
        public TreeNode sortedArrayToBST(int[] num) {
            return createTree(num, 0, num.length - 1);
        }
        public TreeNode createTree(int[] num, int low, int high) {
            if (low > high) return null;
            int mid = low + (high - low) / 2;
            TreeNode node = new TreeNode(num[mid]);
            node.left = createTree(num, low, mid - 1);
            node.right = createTree(num, mid + 1, high);
            return node;
        }
    }

    /**
     * given a sorted list, create a balanced BST
     */
    static class SortedListBuilder{
        ListNode current;
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null) return null;
            current = head;
            int length = length(head);
            return buildTree(length);
        }

        public int length(ListNode head){
            int length = 0;
            while(head != null){
                head = head.next;
                length++;
            }
            return length;
        }

        public TreeNode buildTree(int length){
            if(length == 0) return null;
            TreeNode left = buildTree(length / 2);
            TreeNode node = new TreeNode(current.val);
            current = current.next;
            node.left = left;
            node.right = buildTree(length - 1 - length/2);
            return node;
        }
    }

    static class PreInOrderBuilder{
        int offset = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            offset = 0;
            return buildTree(preorder, inorder, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int[] inorder, int low, int high){
            if(low > high) return null;
            int cur = preorder[offset++];
            int mid = low;
            while(mid <= high && inorder[mid] != cur) mid++;
            TreeNode node = new TreeNode(cur);
            node.left = buildTree(preorder, inorder, low, mid - 1);
            node.right = buildTree(preorder, inorder, mid + 1, high);
            return node;
        }
    }

    static class PostInOrderBuilder{
        int offset;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            offset = inorder.length - 1;
            return buildTree(postorder, inorder, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] postorder, int[] inorder, int low, int high){
            if(low > high) return null;
            int cur = postorder[offset--];
            int mid = high;
            while(mid >= low && inorder[mid] != cur) mid--;
            TreeNode node = new TreeNode(cur);
            node.right = buildTree(postorder, inorder, mid + 1, high);
            node.left = buildTree(postorder, inorder, low, mid - 1);
            return node;
        }
    }

}
