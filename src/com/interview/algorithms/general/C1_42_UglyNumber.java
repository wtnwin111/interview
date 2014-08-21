package com.interview.algorithms.general;

import com.interview.basics.model.collection.Heap;

/**
 * Created_By: stefanie
 * Date: 14-7-31
 * Time: 下午10:02
 */

public class C1_42_UglyNumber {
    public static class UnduplicateHeap<T extends Comparable<T>> extends Heap<T>{

        public UnduplicateHeap(int type) {
            super(type);
        }

        @Override
        public void add(T element) {
            if(!store.contains(element)){
                super.add(element);
            }
        }
    }
    public static int[] findNumber(int N){
        int[] numbers = new int[N];
        numbers[0] = 1;
        int i = 2;
        int count = 1;
        while(count < N){
            int tmp = i;
            while(tmp%2 == 0) tmp = tmp/2;
            while(tmp%3 == 0) tmp = tmp/3;
            while(tmp%5 == 0) tmp = tmp/5;
            if(tmp == 1){
                numbers[count++] = i;
            }
            i++;
        }
        return numbers;
    }

    public static int[] find(int N){
        int[] numbers = new int[N];
        Heap<Integer> minHeap = new UnduplicateHeap<>(Heap.MIN_HEAD);
        minHeap.add(1);
        int count = 0;
        while(count < N && count + minHeap.size() < 2*N){
            int tmp = minHeap.pollHead();
            numbers[count++] = tmp;
            minHeap.add(tmp * 2);
            minHeap.add(tmp * 3);
            minHeap.add(tmp * 5);
        }
        while(count < N) {
            numbers[count++] = minHeap.pollHead();
        }

        return numbers;
    }
}
