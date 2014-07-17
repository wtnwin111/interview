package com.interview.basics.model.tree;

/**
 * Created_By: stefanie
 * Date: 14-7-16
 * Time: 下午10:15
 */
public class BinaryTree<T> {
    protected BinaryTreeNode<T> root;

    public BinaryTree(T[] nodeValues){
        this.root = new BinaryTreeNode<T>(nodeValues[0]);
        for(int i = 1; i< nodeValues.length; i ++){
            insert(nodeValues[i]);
        }
    }

    public BinaryTree(BinaryTreeNode root){
        this.root = root;
    }

    public BinaryTreeNode getRoot(){
        return this.root;
    }

    protected void insert(T element){
        insert(new BinaryTreeNode<T>(element), this.root);
        this.resize();
    }

    private void insert(BinaryTreeNode element, BinaryTreeNode<T> node){
        if(node.getLeftChild() == null) node.setLeftChild(element);
        else if(node.getRightChild() == null) node.setRightChild(element);
        else {
            BinaryTreeNode<T> smallChild = node.getLeftChild().size() < node.getRightChild().size()?
                    node.getLeftChild() : node.getRightChild();
            insert(element, smallChild);
        }

    }

    public int resize() {
        if(this.root == null)   return 0;
        return this.root.resize();
    }

    public int reheight(){
        if(this.root == null)   return 0;
        return this.root.reheight();
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public int size() {
        if (root == null)   return 0;
        return root.size();
    }

    public int height(){
        if(root == null)    return 0;
        return root.height();
    }
}
