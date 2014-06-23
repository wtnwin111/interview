package com.interview.algorithms.tree;

import com.interview.basic.graph.model.IndexedPriorityQueue;
import com.interview.datastructures.tree.BinarySearchTree;
import com.interview.datastructures.tree.BinaryTreeNode;
import com.interview.utils.BinaryTreePrinter;
import com.interview.utils.ConsoleReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * Given a BinarySearchTree and value K, find all value pairs whose sum is K in O(n).
 *
 * @author zouzhile (zouzhile@gmail.com)
 *
 */
public class C5_7_KValueNodePairSearch {

    public HashMap<Integer, Integer> search(BinarySearchTree tree, int K) {
        HashMap<Integer, Integer> pairs = new HashMap<Integer, Integer>();

        BinaryTreeNode root = tree.getRoot();
        List<Integer> sortedValues = new ArrayList<Integer>();
        this.traverseInOrder(root, sortedValues);
        int head = 0;
        int tail = sortedValues.size() - 1;
        while(head <= tail) {
            int small = sortedValues.get(head);
            int large = sortedValues.get(tail);
            int sum = small + large;
            if(sum > K)
                tail -- ;
            if(sum < K)
                head ++;
            if(sum == K) {
                pairs.put(small, large);
                head ++;
                tail --;
            }
        }
        return pairs;
    }

    private void traverseInOrder(BinaryTreeNode node, List<Integer> sortedNodes) {
        if(node == null)
            return;
        traverseInOrder(node.getLeftChild(), sortedNodes);
        sortedNodes.add(node.getValue());
        traverseInOrder(node.getRightChild(), sortedNodes);
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
        HashMap<Integer, Integer> pairs = searcher.search(tree, target);
        if(! pairs.isEmpty()) {
            System.out.println("K Value Node Pairs Found !");
            for(Entry<Integer, Integer> pairEntry : pairs.entrySet()) {
                Integer key = pairEntry.getKey();
                Integer value = pairEntry.getValue();
                System.out.println("\t" + key + "\t" + value);
            }
        }
        else 
            System.out.println("K Value Node Pair NOT Found !");
	}
}
