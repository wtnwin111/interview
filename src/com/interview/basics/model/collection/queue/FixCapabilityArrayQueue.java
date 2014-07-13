package com.interview.basics.model.collection.queue;

/**
 * Created_By: stefanie
 * Date: 14-7-13
 * Time: 下午10:13
 */
public class FixCapabilityArrayQueue<T> implements Queue<T> {
    int N = 10;
    T[] array = (T[]) new Object[N];

    int head = 0;
    int tail = 0;

    @Override
    public void push(T item) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
