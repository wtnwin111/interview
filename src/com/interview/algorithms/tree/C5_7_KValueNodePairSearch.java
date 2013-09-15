package com.interview.algorithms.tree;

import com.interview.datastructures.tree.BinarySearchTree;
import com.interview.datastructures.tree.BinaryTreeNode;
import com.interview.utils.BinaryTreePrinter;
import com.interview.utils.ConsoleReader;

import java.util.HashMap;
import java.util.Map.Entry;


class NodePair  {

    private BinaryTreeNode firstNode;
    private BinaryTreeNode secondNode;

    public void setFirstNode(BinaryTreeNode node) {
        this.firstNode = node;
    }

    public BinaryTreeNode getFirstNode() {
        return this.firstNode;
    }

    public void setSecondNode(BinaryTreeNode node) {
        this.secondNode = node;
    }

    public BinaryTreeNode getSecondNode() {
        return this.secondNode;
    }

    @Override
    public int hashCode() {
        int value1 = this.firstNode.getValue();
        int value2 = this.secondNode.getValue();
        if(value1 >= value2)
            return (value1+"\t"+value2).hashCode();
        else
            return (value2+"\t"+value1).hashCode();
    }
    
}

/**
 * KValue Node Pair search implementation. Find the pairs of nodes where the values of the nodes in each pair sum to a given value N
 * @author zouzhile (zouzhile@gmail.com)
 *
 */
public class C5_7_KValueNodePairSearch {

    public HashMap<Integer, NodePair> search(BinarySearchTree tree, int sumValue) {
        BinaryTreeNode current = tree.getRoot();
        HashMap<Integer, NodePair> pairs = new HashMap<Integer, NodePair>();

        this.search(tree, current, pairs, sumValue);
        return pairs;
    }

    public void search(BinarySearchTree tree, BinaryTreeNode currentNode, HashMap<Integer, NodePair> pairs, int sumValue){
        if(currentNode != null) {
            int value = currentNode.getValue();
            int targetValue = sumValue - value;
            BinaryTreeNode matchNode = tree.search(targetValue);
            if(matchNode != null) {
                NodePair pair = new NodePair();
                pair.setFirstNode(currentNode);
                pair.setSecondNode(matchNode);
                pairs.put(pair.hashCode(), pair);
            }

            this.search(tree, currentNode.getLeftChild(), pairs, sumValue);
            this.search(tree, currentNode.getRightChild(), pairs, sumValue);
        }
    }
	
	public static void main(String[] args){
		System.out.println("The K Value Node Pair Search Implementation");
		System.out.println("The Binary Tree is below: ");

        int[] data = new int[]{15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree tree = new BinarySearchTree(data);
        BinaryTreePrinter.print(tree.getRoot());
		
		System.out.print("Please input sum value for the node pair: ");
		int target = new ConsoleReader().readInt();
		System.out.println();
		
        C5_7_KValueNodePairSearch searcher = new C5_7_KValueNodePairSearch();
        HashMap<Integer, NodePair> pairs = searcher.search(tree, target);
        if(! pairs.isEmpty()) {
            System.out.println("K Value Node Pairs Found !");
            for(Entry<Integer, NodePair> pairEntry : pairs.entrySet()) {
                NodePair pair = pairEntry.getValue();
                System.out.println("\t" + pair.getFirstNode().getValue() + "\t" + pair.getSecondNode().getValue());
            }
        }
        else 
            System.out.println("K Value Node Pair NOT Found !");
	}
}
