package com.interview.datastructures.stack;

/**
 * Created_By: zouzhile
 * Date: 9/10/13
 * Time: 9:38 PM
 */
public class BasicStack<T> {

    class Node<T> {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext(){
            return this.next;
        }

        public T getValue() {
            return this.value;
        }
    }

    Node head;
    private int size = 0;

    public void push(T element) {
        Node node = new Node(element);
        if(head == null)
            head = node;
        else {
            node.setNext(head);
            head = node;
        }

        this.size += 1;
    }

    public int getSize() {
        return this.size;
    }

    public T pop() {
        if(head == null)
            return null;

        Node<T> next = head.getNext();

        head.setNext(null);
        Node<T> returnNode = head;
        head = next;

        this.size -= 1;

        return returnNode.getValue();
    }

    public boolean isEmpty(){
        return size <= 0;
    }
}
