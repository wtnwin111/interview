package com.interview.basics.model.tree;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 10/20/14
 * Time: 4:19 PM
 */
public class RedBlackTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    static class RedBlackTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T>{
        public static final boolean BLACK = false;
        public static final boolean RED = true;
        public boolean color = RED;
        public RedBlackTreeNode(T value) {
            super(value);
        }

        public boolean isRed(BinaryTreeNode node){
            return ((node != null) && node instanceof RedBlackTreeNode
                    && ((RedBlackTreeNode)node).color == RED);
        }

        public RedBlackTreeNode rotateRight(){
            RedBlackTreeNode tmp = (RedBlackTreeNode) this.left;
            this.setLeft(tmp.right);
            tmp.setRight(this);
            tmp.color = this.color;
            this.color = RED;
            return tmp;
        }

        public RedBlackTreeNode rotateLeft(){
            RedBlackTreeNode tmp = (RedBlackTreeNode) this.right;
            this.setRight(tmp.left);
            tmp.setLeft(this);
            tmp.color = this.color;
            this.color = RED;
            return tmp;
        }

        public void flipColors(){
            this.color = RED;
            ((RedBlackTreeNode)this.left).color = BLACK;
            ((RedBlackTreeNode)this.right).color = BLACK;
        }
    }

    public RedBlackTree(T[] values) {
        super(values);
    }

    public RedBlackTree(BinaryTreeNode root) {
        super(root);
    }

    @Override
    protected BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T element) {
        if(node == null)    return new RedBlackTreeNode<>(element);
        int cmp = node.value.compareTo(element);
        if (cmp == 0) node.count++;
        else if (cmp > 0) node.setLeft(insert(node.left, element));
        else node.setRight(insert(node.right, element));
        RedBlackTreeNode bnode = (RedBlackTreeNode) node;
        if (bnode.isRed(bnode.right) && !bnode.isRed(bnode.left)) node = bnode.rotateLeft();
        if (bnode.isRed(bnode.left) && bnode.isRed(bnode.left.left)) node = bnode.rotateRight();
        if (bnode.isRed(bnode.left) && bnode.isRed(bnode.right)) bnode.flipColors();
        return node;
    }

//    @Override
//    protected BinaryTreeNode<T> delete(BinaryTreeNode<T> node, T element){
//
//    }
}
