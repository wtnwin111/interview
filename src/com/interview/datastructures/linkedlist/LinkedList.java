package com.interview.datastructures.linkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/1/14
 * Time: 5:00 PM
 */
public class LinkedList<T extends Comparable<T>> implements LinkedListIface<T>{
    Node<T> head;
    int size = 0;

    public void add(T element){
        Node node = new Node(element);
        if(size == 0){
            setHead(node);
        } else {
            Node<T> current = getHead();
            while(current.getNext() != null) current = current.getNext();
            current.setNext(node);
        }
        size++;
    }

    public T get(int index){
        Node<T> node = getNode(index);
        if(node != null) return node.getValue();
        else return null;
    }

    public int indexOf(T element){
        int index = 0;
        Node<T> current = getHead();
        while(current != null && !current.getValue().equals(element)){
            index++;
            current = current.getNext();
        }
        if(current == null) return -1;
        else return index;
    }

    public boolean contains(T element){
        return indexOf(element) >= 0? true: false;
    }

    public T removeElement(T element){
        int index = indexOf(element);
        return remove(index);
    }

    public T remove(int index){
        if(index >= 0 && index < size){
            int i = 0;
            Node<T> current = getHead();
            Node<T> previous = null;
            while(i < index){
                previous = current;
                current = current.getNext();
                i++;
            }
            if(previous != null) previous.setNext(current.getNext());
            else setHead(current.getNext());
            size--;
            return current.getValue();
        } else {
            return null;
        }
    }

    public int size(){
        return size;
    }

    public T previous(T element){
        int index = indexOf(element);
        if(index > 0){
            return get(index - 1);
        } else {
            return null;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head){
        this.head = head;
    }

    protected Node<T> getNode(int index){
        if(index >= 0 && index < size){
            int i = 0;
            Node<T> current = getHead();
            while(i < index){
                current = current.getNext();
                i++;
            }
            return current;
        } else {
            return null;
        }
    }
}
