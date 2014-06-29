package com.interview.algorithms.list;

import com.interview.datastructures.list.Node;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-6-29
 * Time: 下午9:05
 */
public class C3_1_SortedListsMergerTest extends TestCase {
    C3_1_SortedListsMerger merger = new C3_1_SortedListsMerger();

    public void testCase1() throws Exception {
        System.out.println("Test case 1");
        int[] list1 = {10, 11, 12, 13, 14};
        int[] list2 = {1, 2, 3, 4, 5, 6};
        Node nodeList1 = constractList(list1);
        Node nodeList2 = constractList(list2);
        Node finalHead = merger.merge(nodeList1, nodeList2);
        printList(finalHead);
    }

    public void testCase2() throws Exception {
        System.out.println("Test case 2");
        int[] list3 = {1, 2, 3, 4, 5, 6};
        int[] list4 = {10, 11, 12, 13, 14};
        Node nodeList1 = constractList(list3);
        Node nodeList2 = constractList(list4);
        Node finalHead = merger.merge(nodeList1, nodeList2);
        printList(finalHead);
    }

    public void testCase3() throws Exception {
        System.out.println("Test case 3");
        int[] list5 = {1, 3, 7, 9, 11};
        int[] list6 = {2, 4, 6, 8, 10};
        Node nodeList1 = constractList(list5);
        Node nodeList2 = constractList(list6);
        Node finalHead = merger.merge(nodeList1, nodeList2);
        printList(finalHead);
    }

    public void testCase4() throws Exception {
        System.out.println("Test case 4");
        int[] list7 = {1, 3, 7, 9, 11};
        int[] list8 = {};
        Node nodeList1 = constractList(list7);
        Node nodeList2 = constractList(list8);
        Node finalHead = merger.merge(nodeList1, nodeList2);
        printList(finalHead);
    }

    public void testCase5() throws Exception {
        System.out.println("Test case 5");
        int[] list9 = {};
        int[] list10 = {1, 3, 7, 9, 11};
        Node nodeList1 = constractList(list9);
        Node nodeList2 = constractList(list10);
        Node finalHead = merger.merge(nodeList1, nodeList2);
        printList(finalHead);
    }

    public void testCase6() throws Exception {
        System.out.println("Test case 6");
        int[] list11 = {1, 3, 7, 9, 11, 11, 11, 11, 11, 20};
        int[] list12 = {2, 4, 6, 8, 8, 8, 8, 8, 8, 9, 10, 20, 70};
        Node nodeList1 = constractList(list12);
        Node nodeList2 = constractList(list11);
        Node finalHead = merger.merge(nodeList1, nodeList2);
        printList(finalHead);
    }

    private static Node constractList(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        Node head = new Node(String.valueOf(nums[0]), null);
        Node current = head;
        for(int i = 1; i < nums.length; i++){
            Node next = new Node(String.valueOf(nums[i]), null);
            current.setNext(next);
            current = next;
        }
        return head;
    }

    private static void printList(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.getValue() + " ");
            current = current.next();
        }
        System.out.println();
    }
}