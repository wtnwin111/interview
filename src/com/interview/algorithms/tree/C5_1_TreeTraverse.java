package com.interview.algorithms.tree;

import com.interview.basics.model.collection.list.ArrayList;
import com.interview.basics.model.collection.list.List;
import com.interview.basics.model.collection.queue.LinkedQueue;
import com.interview.basics.model.collection.queue.Queue;
import com.interview.basics.model.tree.BinarySearchTree;
import com.interview.basics.model.tree.BinaryTreeNode;

interface Processor<T>{
    public void process(T element);
}

class PrintProcessor<T> implements Processor<T>{

    @Override
    public void process(T element) {
        System.out.print(element + "\t");
    }
}

public class C5_1_TreeTraverse {

	public void traversInDepthFirstOrder(BinaryTreeNode tree, Processor processor){
		if(tree == null)
			return;
		
		//System.out.print(tree.getValue() + " ");
        processor.process(tree.getValue());
		traversInDepthFirstOrder(tree.getLeftChild(), processor);
		traversInDepthFirstOrder(tree.getRightChild(), processor);
	}
	
	public void traverseInBreadthFirstOrder(BinaryTreeNode tree, Processor processor) {
		if(tree == null)
			return;
		
		Queue<BinaryTreeNode> pendings = new LinkedQueue<BinaryTreeNode>();
		pendings.push(tree);
		
		while(pendings.size() > 0) {
			BinaryTreeNode node = pendings.pop();
			//System.out.print(node.getValue() + " ");
            processor.process(node.getValue());
			// add children to pendings
			if(node.getLeftChild() != null)
				pendings.push(node.getLeftChild());
			if(node.getRightChild() != null)
				pendings.push(node.getRightChild());
		}		
		
	}
	
	public void traverseByPreOrder(BinaryTreeNode tree, Processor processor) {
		if(tree == null)
			return;
		
		//System.out.print(tree.getValue() + " ");
        processor.process(tree.getValue());
		traverseByPreOrder(tree.getLeftChild(), processor);
		traverseByPreOrder(tree.getRightChild(), processor);
	}
	
	public void traverseByInOrder(BinaryTreeNode tree, Processor processor){
		if(tree == null)
			return;
		
		traverseByInOrder(tree.getLeftChild(), processor);
		//System.out.print(tree.getValue() + " ");
        processor.process(tree.getValue());
		traverseByInOrder(tree.getRightChild(), processor);
	}
	
	public void traverseByPostOrder(BinaryTreeNode tree, Processor processor) {
		if(tree == null)
			return;
		traverseByPostOrder(tree.getLeftChild(), processor);
		traverseByPostOrder(tree.getRightChild(), processor);
		//System.out.print(tree.getValue() + " ");
        processor.process(tree.getValue());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("The Tree Traverse Implementation");
		System.out.println("========================================================================");

		System.out.println("Tree Structure : \n--------");
		System.out.println("            6");
		System.out.println("           / \\ ");
		System.out.println("          4   8");
		System.out.println("         / \\ / \\ ");
		System.out.println("        3  5 7  9");

//		ConsoleReader reader = new ConsoleReader();
//		System.out.print("Please input a list of tree node values: ");
		Integer[] array = new Integer[]{6,4,8,3,5,7,9};
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(array);

        C5_1_TreeTraverse runner = new C5_1_TreeTraverse();

        System.out.println("\nTree Traversal Results : \n--------");
        System.out.print("\tPreOrderTraversal: ");
        List<Integer> list = new ArrayList<Integer>();
        runner.traverseByPreOrder(tree.getRoot(), new PrintProcessor());

        System.out.print("\n\tInOrderTraversal: ");
        runner.traverseByInOrder(tree.getRoot(), new PrintProcessor());

        System.out.print("\n\tPostOrderTraversal: ");
        runner.traverseByPostOrder(tree.getRoot(), new PrintProcessor());

        System.out.print("\n\tBreadth First Traversal: ");
        runner.traverseInBreadthFirstOrder(tree.getRoot(), new PrintProcessor());

        System.out.print("\n\tDepth First Traversal: ");
        runner.traversInDepthFirstOrder(tree.getRoot(), new PrintProcessor());
        
	}

}
