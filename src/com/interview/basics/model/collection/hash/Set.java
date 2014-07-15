package com.interview.basics.model.collection.hash;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/15/14
 * Time: 3:14 PM
 */
public interface Set<T extends Comparable>{
    public void add(T element);
    public T get(int index);
    public boolean contains(T element);
    public T remove(T element);
    public int size();
    public boolean isEmpty();
}
