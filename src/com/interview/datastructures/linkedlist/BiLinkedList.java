package com.interview.datastructures.linkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/1/14
 * Time: 6:26 PM
 */
public class BiLinkedList<T extends Comparable<T>> extends LinkedList<T> implements LinkedListIface<T>{
    BiNode<T> head;

    public void add(T element){
        BiNode node = new BiNode(element);
        if(size == 0){
            head = node;
        } else {
            Node<T> current = head;
            while(current.getNext() != null) current = current.getNext();
            current.setNext(node);
            node.setPrev(current);
        }
        size++;
    }

    public T remove(int index){
        if(index >= 0 && index < size){
            int i = 0;
            BiNode<T> current = head;
            while(i < index){
                current = current.getNext();
                i++;
            }
            if(current.getPrev() != null) current.getPrev().setNext(current.getNext());
            else head = current.getNext();
            if(current.getNext()!= null) current.getNext().setPrev(current.getPrev());
            size--;
            return current.getValue();
        } else {
            return null;
        }
    }

    public T previous(T element){
        BiNode<T> current = head;
        while(current != null && !current.getValue().equals(element)){
            current = current.getNext();
        }
        if(current != null && current.getPrev() == null) return current.getPrev().getValue();
        else return null;
    }
}
