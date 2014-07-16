package com.interview.basics.model.tree;

import com.interview.utils.BinaryTreePrinter;

public class BinarySearchTree<T extends Comparable> {

	private BinaryTreeNode root;
	
	public BinarySearchTree(T[] nodeValues){
		this.root = new BinaryTreeNode(nodeValues[0]);
		for(int i = 1; i< nodeValues.length; i ++){
			insert(nodeValues[i]);
		}
	}

    public BinaryTreeNode getRoot(){
        return this.root;
    }

    /**
     * Insert the new node as a leaf node.
      * @param newValue
     */
	public void insert(T newValue){
		BinaryTreeNode node = root;
		boolean stop = false;
        // The while loop looks up the right leaf node position for the new node.
		while(!stop){
			if (newValue.compareTo(node.getValue()) <= 0){
				if (node.getLeftChild() == null){
					BinaryTreeNode newNode = new BinaryTreeNode(newValue);
					node.setLeftChild(newNode);
					newNode.setParent(node);
					stop = true;
				} else {
					node = node.getLeftChild();
				}
			} else {
				if (node.getRightChild() == null){
					BinaryTreeNode newNode = new BinaryTreeNode(newValue);
					node.setRightChild(new BinaryTreeNode(newValue)); 
					newNode.setParent(node);
					stop = true;
				} else {
					node = node.getRightChild();
				}				
			}
		}
	}

    public int resize() {
        if(this.root == null)
            return 0;
        return this.root.resize();
    }

    /**
     *  See http://www.algolist.net/Data_structures/Binary_search_tree/Removal
     */
	public void delete(BinaryTreeNode node){	
		if (node == null){
			return;
		}
		BinaryTreeNode parent = node.getParent();
		
		if(node.getLeftChild() == null && node.getRightChild() == null){ 
			// The node to delete has no child
            // directly remove the child from its parent
			if (parent == null) {
				this.root = null;
				return;
			} 
			if (node == parent.getLeftChild()){
				parent.setLeftChild(null);
			} else if (node == parent.getRightChild()){
				parent.setRightChild(null);
			}		
		} else if ((node.getLeftChild() == null && node.getRightChild() != null) ||
                (node.getLeftChild() != null && node.getRightChild() == null)){
			// only has a single child
            // connects the child directly to the parent, i.e. delete the node by skipping it.
            boolean hasLeftChild = node.getLeftChild() != null;
            BinaryTreeNode child = hasLeftChild ? node.getLeftChild() : node.getRightChild();
            if(hasLeftChild)
                parent.setLeftChild(child);
            else
                parent.setRightChild(child);
            child.setParent(parent);
		} else {
			// the given node has both left and right child
			// replace node with its direct successor
			BinaryTreeNode successor = this.successor(node);
			node.setValue(successor.getValue());
			this.delete(successor);
		}

	}
	
	public BinaryTreeNode search(T value){
		BinaryTreeNode node = this.root;
		while (node != null) {
			if (node.getValue() == value){
				break;
			} else if (value.compareTo(node.getValue()) < 0){
				node = node.getLeftChild();
			} else {
				node = node.getRightChild();
			}
		}
		return node;
	}

    public boolean isEmpty(){
        return this.root == null;
    }

    public BinaryTreeNode<T> maximum(BinaryTreeNode node){
        while(node.getRightChild() != null)
            node = node.getRightChild();
        return node;
    }

    public BinaryTreeNode maximum(){
        if(this.isEmpty())
            return null;
        return maximum(this.root);
    }

    public BinaryTreeNode minimum(BinaryTreeNode node){
        while(node.getLeftChild() != null)
            node = node.getLeftChild();
        return node;
    }

    public BinaryTreeNode minimum() {
        if(this.isEmpty())
            return null;
        return minimum(this.root);
    }

    /**
     *
     * @param node
     * @return  The direct successor of the given node. Return null if not exist.
     */
    public BinaryTreeNode successor(BinaryTreeNode node) {
        if(node == null)
            return null;
        if(node.getRightChild() != null)
            return minimum(node.getRightChild());

        BinaryTreeNode parent = node.getParent();
        while(parent != null && parent.getRightChild() == node) {
            node = parent;
            parent = node.getParent();
        }
        return parent;
    }

    /**
     *
     * @param node
     * @return The direct predecessor of the given node. Return null if not exist.
     */
    public BinaryTreeNode predecessor(BinaryTreeNode node) {
        if(node == null)
            return null;
        if(node.getLeftChild() != null)
            return maximum(node.getLeftChild());
        BinaryTreeNode parent = node.getParent();
        while(parent != null && parent.getLeftChild() == node){
            node = parent;
            parent = node.getParent();
        }
        return parent;
    }

    public int size() {
        if (root == null)
            return 0;
        return root.size();
    }

    public int rank(BinaryTreeNode node) {
        return node.size() + 1;
    }

    public BinaryTreeNode select(int k){
        return select(this.root, k);
    }

    private BinaryTreeNode select(BinaryTreeNode root, int k) {
        if(k > root.size())
            return null;
        int leftTreeSize = root.getLeftChild() == null ? 0 : root.getLeftChild().size();
        if(leftTreeSize == k - 1)
            return root;
        else if (leftTreeSize >= k)
            return select(root.getLeftChild(), k);
        else
            return select(root.getRightChild(), k - leftTreeSize - 1);
    }



    public static void main(String[] args) throws Exception {
        System.out.println("** Binary Search Tree **");
        Integer[] data = new Integer[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};

        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(data);
        tree.resize();
        System.out.println("The binary tree is below: \n -------------");
        BinaryTreePrinter.print(tree.getRoot());
        System.out.println("--------------------");
        System.out.println("Max: " + tree.maximum().getValue());
        System.out.println("Min: " + tree.minimum().getValue());
        System.out.println("Size:" + tree.size());

        System.out.println("Target Node : 7 ");
        BinaryTreeNode target = tree.search(7);
        System.out.println("Found node (value = 7) ? : " + (target != null));
        if(target != null) {
            System.out.println("Successor: " + (tree.successor(target) == null ? "Not Exist" : tree.successor(target).getValue()));
            System.out.println("Predecessor: " + (tree.predecessor(target) == null ? "Not Exist" : tree.predecessor(target).getValue()));
        }

        System.out.println("\n\nInserting a node 8 \n ------------ " );
        tree.insert(8);
        tree.resize();
        BinaryTreePrinter.print(tree.getRoot());
        System.out.println("--------------------");
        System.out.println("Max: " + tree.maximum().getValue());
        System.out.println("Min: " + tree.minimum().getValue());
        System.out.println("Size:" + tree.size());

        System.out.println("\n\nDeleting the node 6 \n ------------");
        BinaryTreeNode node = tree.search(6);
        tree.delete(node);
        tree.resize();
        BinaryTreePrinter.print(tree.getRoot());
        System.out.println("--------------------");
        System.out.println("Max: " + tree.maximum().getValue());
        System.out.println("Min: " + tree.minimum().getValue());
        System.out.println("Size:" + tree.size());

        int index = 7;
        System.out.println("\n\nSelecting the " + index + "th node in ascending order \n" +
                " ------------");
        BinaryTreePrinter.print(tree.getRoot());
        System.out.println("--------------------");
        System.out.println("Selected Node: " + tree.select(index).getValue());
        BinaryTreeNode node18 = tree.search(18);
        System.out.println("Node(18) is ranked as : " + tree.rank(node18) + "th node");
    }
}
