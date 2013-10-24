package com.interview.algorithms.list;

import com.interview.datastructures.list.Node;
import com.interview.utils.ConsoleReader;

public class C3_1_SortedListsMerger {

    /**
     * Repeatedly do the followings until one list reaches the end.
     *     1) Pick the smaller node from the current nodes of the two lists.
     *     2) Append the smaller one to the result list
     *     3) For the current node of each list, shift it down the list until
     *     the node's value is different and bigger than the tail of result list.
     *
     * For the remaining list with elements not visited, repeatedly do the followings:
     *     1) Shift the current node of the remaining list until the node's value
     *     is different and bigger than the tail of result list.
     *     2) Append the node to the result list
     *
     */
    public Node merge(Node node1, Node node2) {

        if (node1 == null || node2 == null)
            return (node1 == null ? node2 : node1);

        Node head = null, tail = null;

        while (node1 != null && node2 != null) {   // while #1
            System.out.println("Node 1: " + node1.getValue() + "\t Node 2: " + node2.getValue());
            // determine smaller node
            // Always append smallest node to the result list
            Node smallerNode = node1.compareTo(node2) <= 0 ? node1 : node2;
            // shift node1 and node2 pointer to a node with bigger different value
            while (node1 != null && node1.compareTo(smallerNode) == 0)
                node1 = node1.next();
            while (node2 != null && node2.compareTo(smallerNode) == 0)
                node2 = node2.next();
            // append smallerNode to resultList
            smallerNode.setNext(null) ;
            if (head == null) {
                head = smallerNode ;
                tail = head;
            } else {
                tail.setNext(smallerNode);
                tail = tail.next();
            }
        }

        Node remainingNode = node1 == null ? node2 : node1;
        while(remainingNode != null) {
            if(remainingNode.compareTo(tail) != 0) {
                tail.setNext(remainingNode);
                tail = tail.next();
            }
            remainingNode = remainingNode.next();
            tail.setNext(null);
        }

        return head;
    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConsoleReader reader = new ConsoleReader();
		System.out.println("Merge two sorted list");
		System.out.println("===============================================================================");
		System.out.print("Please input the first int array: ");
		int[] array1 = reader.readSortedIntItems();
		Node list1 = Node.createList(array1);
		System.out.print("Please input the second int array: ");
		int[] array2 = reader.readSortedIntItems();
		Node list2 = Node.createList(array2);

		C3_1_SortedListsMerger merger = new C3_1_SortedListsMerger();
		Node node = merger.merge(list1, list2);
		System.out.print("The merged list is : ");
		while (node != null) {
			System.out.print(node.getValue() + " ");
			node = node.next();
		}
	}

}
