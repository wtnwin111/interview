package com.interview.basics.sort;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 10/16/14
 * Time: 4:30 PM
 */
public class SimplestQuickSorter<T extends Comparable<T>> extends Sorter<T> {
    static Random RAND = new Random();
    @Override
    public T[] sort(T[] input) {
        sort(input, 0, input.length - 1);
        return input;
    }

    private void sort(T[] input, int low, int high){
        if(low >= high) return;
        int rand = low + RAND.nextInt(high - low);  //random shuffle
        if(rand != low) swap(input, rand, low);
        int i = low;
        for(int j = low + 1; j <= high; j++)
            if(input[j].compareTo(input[low]) < 0 && ++i != j)  swap(input, i, j);
        swap(input, low, i);
        sort(input, low, i - 1);
        sort(input, i + 1, high);
    }
}
