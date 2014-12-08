package com.interview.flag.o;

import com.interview.leetcode.utils.TreeNode;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created_By: stefanie
 * Date: 14-12-8
 * Time: 下午2:31
 */
public class O14_BSTIterator implements Iterator<TreeNode>{
    private TreeNode _current;
    private Stack<TreeNode> _stack;

    public O14_BSTIterator(TreeNode root){
        this._current = root;
        _stack = new Stack<>();
    }

    @Override
    public boolean hasNext() {
       return _current != null || !_stack.empty();
    }

    @Override
    public TreeNode next() {
        while(_current != null){
            _stack.push(_current);
            _current = _current.left;
        }
        if(!_stack.isEmpty()){
            TreeNode node = _stack.pop();
            _current = node.right;
            return node;
        }
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Can delete items during iteration");
    }

    public static void main(String[] args){
        TreeNode root = TreeNode.sampleBST();
        O14_BSTIterator iterator = new O14_BSTIterator(root);
        while(iterator.hasNext()){
            System.out.print(iterator.next().val + " ");
        }
    }
}
