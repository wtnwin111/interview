package com.interview.algorithms.array;

import com.interview.basics.sort.QuickSorter;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 8/8/14
 * Time: 12:07 PM
 */
public class C4_43_FindMidNumber {

    public static boolean[] find(Integer[] numbers){
        boolean[] mark = new boolean[numbers.length];
        QuickSorter<Integer> sorter = new QuickSorter<>();
        Integer[] sorted = sorter.sort(numbers.clone());
        for(int i = 0; i < numbers.length; i++)
            mark[i] = numbers[i] == sorted[i];
        return mark;
    }

    public static boolean[] findAnswer(Integer[] numbers){
        boolean[] mark = new boolean[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            mark[i] = markOne(numbers, i);
        }
        return mark;
    }

    private static boolean markOne(Integer[] numbers, int i){
        for(int j = 0; j < i; j++)
            if(numbers[j] > numbers[i]) return false;
        for(int j = i+1; j < numbers.length; j++)
            if(numbers[j] < numbers[i]) return false;
        return true;
    }
}
