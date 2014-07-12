package com.interview.basics.model.collection.list;

/**
 * Created_By: stefanie
 * Date: 14-7-1
 * Time: 下午10:14
 */

public class LinkedList<T> implements List<T> {
    Node<T> head;
    int size;

    @Override
    public void add(T element) {
        add(size, element);
    }

    @Override
    public void add(int index, T element) {
        Node node = new Node(element);
        if (index >= 0 && index <= size) {
            if (index == 0) {
                node.next = head;
                head = node;
            } else {
                Node<T> current = head;
                for (int i = 0; i < index - 1; i++) current = current.next;
                node.next = current.next;
                current.next = node;
            }
            size++;
        }
    }

    @Override
    public T get(int index) {
        if (!checkIndex(index)) return null;
        Node<T> node = getNode(index);
        if (node != null) return node.item;
        else return null;
    }

    @Override
    public void set(int index, T element) {
        if (checkIndex(index)){
            Node<T> node = getNode(index);
            if (node != null) node.item = element;
        }
    }

    @Override
    public int indexOf(T element) {
        int index = 0;
        for (Node<T> current = head; current != null && !current.item.equals(element); current = current.next) index++;
        if (index >= size) return -1;
        else return index;
    }

    @Override
    public boolean contains(T element) {
        int index = indexOf(element);
        return index >= 0;
    }

    @Override
    public T remove(int index) {
        if (!checkIndex(index)) return null;
        int i = 0;
        Node<T> current = head;
        Node<T> previous = null;
        while (i++ < index) {
            previous = current;
            current = current.next;
        }
        size--;
        return current.item;
    }

    @Override
    public T remove(T element) {
        Node<T> current = head;
        if(element.equals(current.item))    head = head.next;
        else{
            while(current.next != null){
                if(element.equals(current.next.item)){
                    current.next = current.next.next;
                    size--;
                    break;
                }
                current = current.next;
            }
        }
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        int i = 0;
        for(Node current = head; current!= null; current = current.next){
            arr[i++] = (T)current.item;
        }
        return arr;
    }

    protected Node<T> getNode(int index) {
        int i = 0;
        Node<T> current = head;
        while (i++ < index) current = current.next;
        return current;
    }

    private boolean checkIndex(int index) {
        if (index >= 0 && index < size) return true;
        else return false;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> node){
        this.head = node;
    }
}
