package com.interview.basics.sort;

import com.interview.basics.model.collection.Heap;

public class HeapSorter<T extends Comparable<T>> extends Sorter<T>{
	//use min head or max head, up=true is max head.
	public boolean up = true;

	public T[] sort(T[] input) {
        Heap<T> heap;
        if (up) heap = new Heap<>(Heap.MAX_HEAD);
        else heap = new Heap<>(Heap.MIN_HEAD);

        int N = input.length;
        for (int i = 0; i < N; i++) heap.add(input[i]);
        for (int i = 0; i < N; i++)
            input[i] = heap.pollHead();
        return input;
    }
}
