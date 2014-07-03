package com.interview.basics.model.linkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/1/14
 * Time: 6:02 PM
 */
public class Node<T extends Comparable<T>>{
    T value;
    Node next;

    Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}