package com.interview.basics.model.tree;

import com.interview.utils.BinaryTreePrinter;

public class BinarySearchTree<T extends Comparable> extends BinaryTree<T> {

    public BinarySearchTree(T[] values) {
        for(T element : values) insert(element);
    }

    public BinarySearchTree(BinaryTreeNode root) { super(root);}

    /**
     * Insert the new node as a leaf node.
      * @param element
     */
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

    public BinaryTreeNode maximum(){
        return root == null? null : maximum(this.root);
    }

    private BinaryTreeNode<T> maximum(BinaryTreeNode node){
        while(node.right != null)   node = node.right;
        return node;
    }

    public BinaryTreeNode minimum() {
        return root == null? null : minimum(this.root);
    }

    private BinaryTreeNode minimum(BinaryTreeNode node){
        while(node.left != null)    node = node.left;
        return node;
    }

    public BinaryTreeNode<T> successor(BinaryTreeNode<T> node) {
        if(node == null)        return null;
        if(node.right != null)  return minimum(node.right);
        BinaryTreeNode<T> parent = node.parent;
        while(parent != null && parent.right == node) {
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    public BinaryTreeNode<T> predecessor(BinaryTreeNode node) {
        if(node == null)        return null;
        if(node.left != null)   return maximum(node.left);
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

    /**
     *  See http://www.algolist.net/Data_structures/Binary_search_tree/Removal
     */
    public void delete(BinaryTreeNode node){
//		if (node == null){
//			return;
//		}
//		BinaryTreeNode parent = node.getParent();
//
//		if(node.getLeft() == null && node.getRightChild() == null){
//			// The node to delete has no child
//            // directly remove the child from its parent
//			if (parent == null) {
//				this.root = null;
//				return;
//			}
//			if (node == parent.getLeft()){
//				parent.setLeft(null);
//			} else if (node == parent.getRightChild()){
//				parent.setRightChild(null);
//			}
//		} else if ((node.getLeft() == null && node.getRightChild() != null) ||
//                (node.getLeft() != null && node.getRightChild() == null)){
//			// only has a single child
//            // connects the child directly to the parent, i.e. delete the node by skipping it.
//            boolean hasLeftChild = node.getLeft() != null;
//            BinaryTreeNode child = hasLeftChild ? node.getLeft() : node.getRightChild();
//            if(hasLeftChild)
//                parent.setLeft(child);
//            else
//                parent.setRightChild(child);
//            child.setParent(parent);
//		} else {
//			// the given node has both left and right child
//			// replace node with its direct successor
//			BinaryTreeNode successor = this.successor(node);
//			node.setValue(successor.getValue());
//			this.delete(successor);
//		}

    }



    public static void main(String[] args) throws Exception {
        System.out.println("** Binary Search Tree **");
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};

        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        tree.resize();
        System.out.println("The binary tree is below: \n -------------");
        BinaryTreePrinter.print(tree.getRoot());
        System.out.println("--------------------");
        System.out.println("Max: " + tree.maximum().value);
        System.out.println("Min: " + tree.minimum().value);
        System.out.println("Size:" + tree.size());

        System.out.println("Target Node : 7 ");
        BinaryTreeNode target = tree.search(7);
        System.out.println("Found node (value = 7) ? : " + (target != null));
        if(target != null) {
            System.out.println("Successor: " + (tree.successor(target) == null ? "Not Exist" : tree.successor(target).value));
            System.out.println("Predecessor: " + (tree.predecessor(target) == null ? "Not Exist" : tree.predecessor(target).value));
        }

        System.out.println("\n\nInserting a node 8 \n ------------ " );
        tree.insert(8);
        tree.resize();
        BinaryTreePrinter.print(tree.getRoot());
        System.out.println("--------------------");
        System.out.println("Max: " + tree.maximum().value);
        System.out.println("Min: " + tree.minimum().value);
        System.out.println("Size:" + tree.size());

        System.out.println("\n\nDeleting the node 6 \n ------------");
        BinaryTreeNode node = tree.search(6);
        tree.delete(node);
        tree.resize();
        BinaryTreePrinter.print(tree.getRoot());
        System.out.println("--------------------");
        System.out.println("Max: " + tree.maximum().value);
        System.out.println("Min: " + tree.minimum().value);
        System.out.println("Size:" + tree.size());

        int index = 7;
        System.out.println("\n\nSelecting the " + index + "th node in ascending order \n" +
                " ------------");
        BinaryTreePrinter.print(tree.getRoot());
        System.out.println("--------------------");
        System.out.println("Selected Node: " + tree.select(index).value);
        System.out.println("Node(18) is ranked as : " + tree.rank(18) + "th node");
    }
}
