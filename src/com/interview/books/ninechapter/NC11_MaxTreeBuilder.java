package com.interview.books.ninechapter;

import com.interview.leetcode.utils.TreeNode;
import com.interview.leetcode.utils.TreeNodePrinter;

import java.util.Stack;

/**
 * Created_By: stefanie
 * Date: 14-12-12
 * Time: 下午5:13
 */

public class NC11_MaxTreeBuilder {
    //Time: O(N), Space O(N)
    public TreeNode build(int[] array){
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0; i < array.length; i++){
            TreeNode node = new TreeNode(array[i]);
            if(!stack.isEmpty()){
                if(stack.peek().val > node.val) {
                    stack.peek().right = node;
                } else {
                    TreeNode n1 = stack.pop();
                    while(!stack.isEmpty() && stack.peek().val < node.val) n1 = stack.pop();
                    node.left = n1;
                    if(!stack.isEmpty()) stack.peek().right = node;
                }
            }
            stack.push(node);
        }
        while(stack.size() > 1) stack.pop();
        return stack.pop();
    }

    public static void main(String[] args){
        NC11_MaxTreeBuilder builder = new NC11_MaxTreeBuilder();
        int[] array = new int[]{1,3,2,8,7,4,6,5};
        TreeNode root = builder.build(array);
        TreeNodePrinter.print(root);
    }
}
