package com.interview.algorithms.array;

/**
 * Created_By: stefanie
 * Date: 14-8-19
 * Time: 下午3:45
 */
public class C4_45_TrickPair {

    public static int find(Integer[] array){
        int count = 0;
        for(int i = 0; i < array.length - 1; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] > array[j]) {
                    //System.out.println(array[i] + "\t" + array[j]);
                    count++;
                }
            }
        }
        return count;
    }
}
