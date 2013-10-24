package com.interview.algorithms.list;

import com.interview.datastructures.list.Node;
import com.interview.utils.ConsoleReader;

/**
 * Find the -M element in a node list
 * 
 * @author zouzhile (zouzhile@gmail.com)
 *
 */
public class C3_3_LastMElementFinder {

	public int findElement(Node list, Node result, int m){
        if(list == null)
            return 0;
        int k = findElement(list.next(), result, m) + 1;
        if(k == m)
            result = list;
		return k;
	}
	
	public static void main(String[] args) {
		System.out.println("Search the Node at the '-M' position in the list");
		System.out.println("===============================================================================");
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Please input the node values: ");
		String[] elements = reader.readStringItems();
		System.out.print("Please input the value of M: ");
		int m = reader.readInt();
		//build the node list
		Node head = null, current = null;
		for(int i = 0; i < elements.length; i++){
			Node node = new Node(elements[i], null);
			if(i == 0){
				head = node;
				current = node;
			} else {
				current.setNext(node);
				current = node;
			}
		}
		C3_3_LastMElementFinder finder = new C3_3_LastMElementFinder();
        Node result = null;
		finder.findElement(head, null, m);
		if (result == null){
			System.out.println("List is empty or its length is smaller than " + m);
		} else {
			System.out.println("The '-M' element is: " + result.getValue());
		}	    
	}

}
