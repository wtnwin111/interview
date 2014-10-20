package com.interview.basics.model.tree;

public class BinarySearchTree<T extends Comparable> extends BinaryTree<T> {

    public BinarySearchTree(T[] values) {
        for(T element : values) insert(element);
    }

    public BinarySearchTree(BinaryTreeNode root) { super(root);}

    @Override
	public void insert(T element){
		root = insert(root, element);
	}

    private BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T element){
        if(node == null) return new BinaryTreeNode<>(element);
        int cmp = node.value.compareTo(element);
        if(cmp == 0) node.count++;
        else if(cmp > 0) node.setLeft(insert(node.left, element));
        else node.setRight(insert(node.right, element));
        node.size++;
        return node;
    }
	
	public BinaryTreeNode search(T value){
	    return search(root, value);
	}

    private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T value){
        if(node == null) return null;
        int cmp = node.value.compareTo(value);
        if(cmp == 0) return node;
        else if(cmp > 0)  return search(node.left, value);
        else return search(node.right, value);
    }

    public BinaryTreeNode<T> max(){
        return root == null? null : max(this.root);
    }

    private BinaryTreeNode<T> max(BinaryTreeNode<T> node){
        while(node.right != null)   node = node.right;
        return node;
    }

    public BinaryTreeNode<T> min() {
        return root == null? null : min(this.root);
    }

    private BinaryTreeNode<T> min(BinaryTreeNode<T> node){
        while(node.left != null)    node = node.left;
        return node;
    }

    public BinaryTreeNode<T> successor(BinaryTreeNode<T> node) {
        if(node == null)        return null;
        if(node.right != null)  return min(node.right);
        BinaryTreeNode<T> parent = node.parent;
        while(parent != null && parent.right == node) {
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    public BinaryTreeNode<T> predecessor(BinaryTreeNode node) {
        if(node == null)        return null;
        if(node.left != null)   return max(node.left);
        BinaryTreeNode<T> parent = node.parent;
        while(parent != null && parent.left == node){
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    public int rank(T element) {
        return rank(root, element);
    }

    private int rank(BinaryTreeNode<T> node, T element){
        if(node == null) return 0;
        int cmp = node.value.compareTo(element);
        if(cmp == 0) return node.left == null? 0 : node.left.size;
        else if(cmp > 0) return rank(node.left, element);
        else return rank(node.right, element) + (node.left == null? 0 : node.left.size) + node.count;
    }

    public BinaryTreeNode<T> select(int k){
        return select(this.root, k);
    }

    private BinaryTreeNode<T> select(BinaryTreeNode<T> node, int k) {
        if(node == null || k > node.size)   return null;
        int left = node.left == null ? 0 : node.left.size;
        if(left == k - 1)   return node;
        else if (left >= k) return select(node.left, k);
        else                return select(node.right, k - left - 1);
    }
    
    public BinaryTreeNode<T> floor(int k){
        return floor(this.root, k);
    }

    private BinaryTreeNode<T> floor(BinaryTreeNode<T> node, int k) {
        if(node == null) return null;
        int cmp = node.value.compareTo(k);
        if(cmp == 0) return node;
        else if(cmp > 0) return floor(node.left, k);
        else {
            BinaryTreeNode<T> floor = floor(node.right, k);
            return floor != null? floor : node;
        }
    }

    public BinaryTreeNode<T> ceil(int k){
        return ceil(this.root, k);
    }

    private BinaryTreeNode<T> ceil(BinaryTreeNode<T> node, int k){
        if(node == null) return null;
        int cmp = node.value.compareTo(k);
        if(cmp == 0)    return node;
        else if(cmp < 0) return ceil(node.right, k);
        else {
            BinaryTreeNode<T> ceil = ceil(node.left, k);
            return ceil != null? ceil : node;
        }
    }

    public void deleteMin(){
        root = deleteMin(this.root);
    }

    private BinaryTreeNode<T> deleteMin(BinaryTreeNode<T> node){
        if(node.left == null) {
            if(node.count == 1) return node.right;
            else node.count--;
        } else {
            node.left = deleteMin(node.left);
        }
        node.size--;
        return node;
    }

    public void deleteMax(){
        root = deleteMax(this.root);
    }

    private BinaryTreeNode<T> deleteMax(BinaryTreeNode<T> node){
        if(node.right == null){
            if(node.count == 1) return node.left;
            else node.count--;
        } else {
            node.right = deleteMax(node.right);
        }
        node.size--;
        return node;
    }

    public void delete(T element){
        delete(this.root, element);
    }

    private BinaryTreeNode<T> delete(BinaryTreeNode<T> node, T element){
        if(node == null) return null;
        int cmp = node.value.compareTo(element);
        if(cmp > 0)         node.left = delete(node.left, element);
        else if(cmp < 0)    node.right = delete(node.right, element);
        else {
            if(node.count > 1) node.count--;
            else {
                if(node.left == null)   return node.right;
                if(node.right == null)  return node.left;
                BinaryTreeNode<T> rightMin = min(node.right);
                rightMin.right = deleteMin(node.right);
                rightMin.left = node.left;
            }
        }
        node.size--;
        return node;
    }
}
