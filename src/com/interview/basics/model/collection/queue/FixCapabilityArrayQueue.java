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
    int size = 0;

    public FixCapabilityArrayQueue(int n){
        this.N = n;
    }

    public FixCapabilityArrayQueue(){
    }

    @Override
    public void push(T item) {
        if(size < N){
            array[tail] = item;
            tail = (tail+1) % N;
            size++;
        } else {
            System.err.println("Stack is full");
        }
    }

    @Override
    public T pop() {
        T element = array[head];
        head = (head + 1) % N;
        size--;
        return element;
    }

    @Override
    public T peek() {
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
