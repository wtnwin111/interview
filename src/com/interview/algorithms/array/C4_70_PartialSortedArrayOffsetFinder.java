package com.interview.algorithms.array;

/**
 * Created_By: stefanie
 * Date: 14-10-21
 * Time: 上午8:58
 */
public class C4_70_PartialSortedArrayOffsetFinder {
    static class Indice {
        int begin;
        int end;
        int getLength(){
            return end - begin + 1;
        }
    }
    public static Indice find(int[] array){
        Indice asc = find(array, true);
        Indice dec = find(array, false);
        return (asc.getLength() > dec.getLength())? dec : asc;
    }

    private static Indice find(int[] array, boolean isAsc){
        Indice indice = new Indice();
        indice.begin = 0;
        indice.end = array.length - 1;
        int[] next = next(array, isAsc);
        while(indice.begin < indice.end && array[indice.begin] == next[indice.begin]) indice.begin++;
        int[] pre = pre(array, !isAsc);
        while(indice.end > indice.begin && array[indice.end] == pre[indice.end]) indice.end--;
        return indice;
    }

    private static int[] next(int[] array, boolean isMin){
        int[] next = new int[array.length];
        next[array.length - 1] = array[array. length - 1];
        for(int i = array.length - 2; i >= 0; i--){
            if(isMin)   next[i] = array[i] < next[i + 1]? array[i] : next[i+1];
            else        next[i] = array[i] > next[i + 1]? array[i]: next[i+1];
        }
        return next;
    }

    private static int[] pre(int[] array, boolean isMin){
        int[] pre = new int[array.length];
        pre[0] = array[0];
        for(int i = 1; i < array.length; i++){
            if(isMin) pre[i] = array[i] < pre[i-1]? array[i] : pre[i-1];
            else pre[i] = array[i] > pre[i-1]? array[i] : pre[i-1];
        }
        return pre;
    }
}
