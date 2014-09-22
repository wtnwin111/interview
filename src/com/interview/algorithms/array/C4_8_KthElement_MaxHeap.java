package com.interview.algorithms.array;

import com.interview.basics.model.collection.Heap;

/**
 * Created_By: stefanie
 * Date: 14-9-22
 * Time: 下午6:15
 */
public class C4_8_KthElement_MaxHeap {
    public static int select(int[] array, int K){
        Heap<Integer> maxHeap = new Heap<Integer>(Heap.MAX_HEAD);
        for(int i = 0; i < array.length; i++){
            if(maxHeap.size() < K) maxHeap.add(array[i]);
            else if(maxHeap.getHead() > array[i]){
                maxHeap.pollHead();
                maxHeap.add(array[i]);
            }
        }
        return maxHeap.getHead();
    }
}
