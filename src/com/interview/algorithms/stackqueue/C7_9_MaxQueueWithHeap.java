package com.interview.algorithms.stackqueue;

import com.interview.basics.model.collection.Heap;
import com.interview.basics.model.collection.queue.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 9/25/14
 * Time: 4:53 PM
 */
public class C7_9_MaxQueueWithHeap<T extends Comparable<T>> implements Queue<T>{
    private QueueNode<T> head;
    private QueueNode<T> tail;
    private int size;

    private Heap<QueueNode<T>> heap = new Heap<>();

    class QueueNode<T extends Comparable<T>> implements Comparable<QueueNode<T>>{
        T value;
        QueueNode<T> next;
        public QueueNode(T value){
            this.value = value;
        }

        @Override
        public int compareTo(QueueNode<T> o) {
            return this.value.compareTo(o.value);
        }
    }

    @Override
    public void push(T item) {
        QueueNode<T> node = new QueueNode<>(item);
        if(head == null){
            head = tail = node;
            return;
        } else {
            tail.next = node;
            tail = node;
        }
        heap.add(node);
        size++;
    }

    @Override
    public T pop() {
        if(head == null) return null;
        QueueNode<T> node = head;
        head = head.next;
        if(tail == node) tail = null;
        size--;
        //delete in the queue
        return node.value;
    }

    @Override
    public T peek() {
        if(head == null) return null;
        else return head.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public T max(){
        if(heap.getHead() == null) return null;
        return heap.getHead().value;
    }
}
