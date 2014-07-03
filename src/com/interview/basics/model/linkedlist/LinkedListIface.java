package com.interview.basics.model.linkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/1/14
 * Time: 6:00 PM
 */
public interface LinkedListIface<T extends Comparable<T>> {
    public void add(T element);
    public T get(int index);
    public int indexOf(T element);
    public boolean contains(T element);
    public T remove(int index);
    public T removeElement(T element);
    public int size();
    public T previous(T element);
}
