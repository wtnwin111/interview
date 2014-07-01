package com.interview.datastructures.linkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/1/14
 * Time: 6:02 PM
 */
public class BiNode<T extends Comparable<T>> extends Node<T>{
    Node prev;

    BiNode(T value) {
        super(value);
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
