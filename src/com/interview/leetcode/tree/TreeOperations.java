package com.interview.leetcode.tree;

import com.interview.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created_By: stefanie
 * Date: 14-11-17
 * Time: 下午3:03
 */
public class TreeOperations {

    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * Using in-order traverse
     */
    //Time:O(N), Space: O(1), StackSpace: O(N)
    static class BSTValidator{
        TreeNode preVisited = null;
        public boolean isValidBST(TreeNode root) {
            if(root == null) return true;
            if(!isValidBST(root.left)) return false;
            if(preVisited != null && root.val <= preVisited.val) return false;
            preVisited = root;
            if(!isValidBST(root.right)) return false;
            return true;
        }
    }

    /**
     * Given a binary tree, flatten it to a linked list in-place.
     * It's a pre-order traverse
     */
    static class TreeFattern{
        TreeNode last = null;
        public void flatten(TreeNode root) {
            if(root == null) return;
            TreeNode right = root.right;
            TreeNode left = root.left;
            if(last != null){
                last.left = null;
                last.right = root;
            }
            last = root;
            flatten(left);
            flatten(right);
        }
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        else return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * Given a binary tree, find its minimum depth.
     */
    //Time: O(N), Space: O(1), StackSpace: O(1)
    public int minDepthDepth(TreeNode root){
        if (root == null) return 0;
        if (root.left == null) return minDepthDepth(root.right) + 1;
        if (root.right == null) return minDepthDepth(root.left) + 1;
        return Math.min(minDepthDepth(root.left), minDepthDepth(root.right)) + 1;
    }
    //Time: O(N), Space: O(N)
    public int minDepthLayer(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.add(root);
        TreeNode rightMost = root;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left == null && node.right == null) break;
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            if(node == rightMost){
                rightMost = (node.right != null? node.right : node.left);
                depth++;
            }
        }
        return depth;
    }

    /**
     * Given a binary tree, determine if it is height-balanced.
     */
    //Time: O(N), Space: O(N)
    public boolean isBalanced(TreeNode root) {
        return maxDepthIfBalanced(root) != -1;
    }

    public int maxDepthIfBalanced(TreeNode root){
        if(root == null) return 0;
        int left = maxDepthIfBalanced(root.left);
        if(left == -1) return -1;
        int right = maxDepthIfBalanced(root.right);
        if(right == -1) return -1;
        return (Math.abs(left - right) > 1)? -1 : Math.max(left, right) + 1;
    }

    /** like reverse linked list, keep cur, parent, left, and do the reverse, be carefully of parent.right.  */
    //Time: O(N) Space O(1)
    public TreeNode upsideDownL(TreeNode root) {
        TreeNode p = root, parent = null, parentRight = null;
        while (p != null) {
            TreeNode left = p.left;
            p.left = parentRight;
            parentRight = p.right;
            p.right = parent;
            parent = p;
            p = left; }
        return parent;
    }

    //Time: O(N) Space O(N)
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

    /**
     * Two elements of a binary search tree (BST) are swapped by mistake.
     * Recover the tree without changing its structure.
     */
    //Time: O(N), Space: O(1)
    static class BSTRecover{
        TreeNode first = null;
        TreeNode second = null;
        TreeNode last = null;
        public void recoverTree(TreeNode root) {
            findBreakPoint(root);
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        public void findBreakPoint(TreeNode node){
            if(node == null) return;
            findBreakPoint(node.left);
            if(last != null && last.val > node.val){//find a break point;
                if(first == null) first = last;
                second = node;
            }
            last = node;
            findBreakPoint(node.right);
        }
    }

    static class NextPopulation{

        class TreeLinkNode{
            int val;
            TreeLinkNode left, right, next;

        }
        //Time: O(N), Space: O(1)
        public void connectCompleteTree(TreeLinkNode root) {
            if(root == null || root.left == null) return;
            root.left.next = root.right;
            connectCompleteTree(root.left);
            connectCompleteTree(root.right);
            TreeLinkNode right = root.right;
            while(right != null && root.next != null){   //root.next == null when root is the root node
                right.next = root.next.left;
                root = right;
                right = right.right;
            }
        }

        //Time: O(N), Space: O(N)
        public void connectNonCompleteTree(TreeLinkNode root) {
            if(root == null) return;
            List<TreeLinkNode> current = new ArrayList<>();
            current.add(root);
            while(current.size() > 0){
                List<TreeLinkNode> children = new ArrayList<>();
                for(TreeLinkNode parent : current){
                    if(parent.left != null) add(children, parent.left);
                    if(parent.right != null) add(children, parent.right);
                }
                current = children;
            }
        }

        private void add(List<TreeLinkNode> list, TreeLinkNode node){
            if(list.size() != 0) list.get(list.size() - 1).next = node;
            list.add(node);
        }
    }

    static class PathSum{

        public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null) return false;
            sum -= root.val;
            if(root.left == null && root.right == null && sum == 0) return true;
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> paths = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            pathSum(root, sum, path, paths);
            return paths;
        }

        public void pathSum(TreeNode node, int sum, List<Integer> path, List<List<Integer>> paths){
            if(node == null) return;
            sum -= node.val;
            path.add(node.val);
            if(node.left == null && node.right == null && sum == 0){ //found a path
                List<Integer> answer = new ArrayList<Integer>();
                answer.addAll(path);
                paths.add(answer);
            } else {
                pathSum(node.left, sum, path, paths);
                pathSum(node.right, sum, path, paths);
            }
            path.remove(path.size() - 1);
        }
    }

}
