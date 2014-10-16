package com.interview.basics.sort;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 10/16/14
 * Time: 5:09 PM
 */
public class ThreeWayQuickSorter<T extends Comparable<T>> extends Sorter<T> {
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
        int m = -1;
        for(int j = low + 1; j <= high; j++){
            if(input[j].compareTo(input[low]) == 0){
                if(m == -1) m = j;
                else swap(input, ++m, j);
            } else if(input[j].compareTo(input[low]) < 0){
                swap(input, ++i, j);
                if(m > -1 && i >= m) swap(input, ++m, j);
            }
        }
        swap(input, low, i);
        sort(input, low, i - 1);
        sort(input, m > -1 ? m + 1 : i + 1, high);
    }
}
