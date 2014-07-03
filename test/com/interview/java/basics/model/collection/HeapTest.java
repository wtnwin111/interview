package com.interview.java.basics.model.collection;

import com.interview.java.basics.model.collection.Heap;
import junit.framework.TestCase;

public class HeapTest extends TestCase {

    public void testMaxHeap(){
        Heap<Integer> heap = new Heap<Integer>(Heap.MAX_HEAD);
        heap.add(2);
        assertEquals(2, heap.getHead().intValue());

        heap.add(3);
        assertEquals(3, heap.getHead().intValue());

        heap.add(1);
        assertEquals(3, heap.getHead().intValue());

        heap.add(3);
        heap.pollHead();
        assertEquals(3, heap.getHead().intValue());
        heap.pollHead();
        assertEquals(2, heap.getHead().intValue());
    }

    public void testMinHeap(){
        Heap<Integer> heap = new Heap<Integer>(Heap.MIN_HEAD);
        heap.add(3);
        assertEquals(3, heap.getHead().intValue());

        heap.add(2);
        assertEquals(2, heap.getHead().intValue());

        heap.add(4);
        assertEquals(2, heap.getHead().intValue());

        heap.pollHead();
        assertEquals(3, heap.getHead().intValue());
    }

}