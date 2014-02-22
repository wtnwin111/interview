package com.interview.algorithms.list;

import com.interview.datastructures.list.Node;

/**
 * Created_By: zouzhile
 * Date: 2/22/14
 * Time: 6:52 PM
 *
 * Write a routine to reverse every k nodes in a given linked list without using additional memory.
 *
 * input : 1,2,3,4,5,6 k:3
   output: 3,2,1,6,5,4
 */
public class C3_5ReverseLinkedList {

    public Node reverse(Node head, int k) {
        // after reverse, the return node is
        // the last node in the first K nodes in the original list
        // which is also the head node in the reversed list
        Node returnNode = null;

        // for the ith K sub list, the two "previous" pointers
        // would point to the (i-1)th K sub list's head and tail "after" reverse
        // This means, after reversing 3,2,1, previousTail points to 3 and previousHead points 1
        Node previousTail = null;

        while(head != null) { // not reached the end of the list
            Node tail = head;
            for(int i = 1; i < k & tail.next() != null; i ++) {
                tail = tail.next();
            }
            Node nextHead = tail.next();
            reverse(head, tail);
            if( previousTail == null) {
                // first K sub list
                previousTail = head;
                returnNode = tail;
            } else
                previousTail.setNext(tail);

            head.setNext(nextHead);
            head = nextHead;
        }
        return returnNode;
    }

    private Node reverse(Node current, Node tail) {
        if(current == tail) {
            return current;
        }

        Node next = reverse(current.next(), tail);
        next.setNext(current);
        return current;
    }

    public static void main(String[] args) {
        String[] data = new String[] {"1","2","3","4","5","6"};
        Node head = new Node(data[0], null);
        Node current = head;
        for(int i = 1; i < data.length; i ++) {
            Node tmp = new Node(data[i], null);
            current.setNext(tmp);
            current = tmp;
        }

        C3_5ReverseLinkedList runner = new C3_5ReverseLinkedList();
        int k = 3;
        head = runner.reverse(head, k);
        while(head != null) {
            System.out.println(head.getValue() + " ");
            head = head.next();
        }
    }
}
