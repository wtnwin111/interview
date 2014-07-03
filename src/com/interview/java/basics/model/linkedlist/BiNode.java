package com.interview.java.basics.model.linkedlist;

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

    public BiNode<T> getNext(){
        return next == null? null:(BiNode) next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
