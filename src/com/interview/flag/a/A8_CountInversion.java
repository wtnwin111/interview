package com.interview.flag.a;

/**
 * Created_By: stefanie
 * Date: 14-12-4
 * Time: 下午9:15
 *
 */

public class A8_CountInversion {
    //Time: O(NlgN)  Space: O(N)
    public static int count(int[] array){
        int[] aux = new int[array.length];
        return count(array, aux, 0, array.length - 1);
    }

    public static int count(int[] array, int[] aux, int low, int high){
        if(low >= high) return 0;
        int mid = low + (high - low)/2;
        int count = count(array, aux, low, mid);
        count += count(array, aux, mid + 1, high);
        count += merge(array, aux, low, mid, high);
        return count;
    }

    public static int merge(int[] array, int[] aux, int low, int mid, int high){
        int count = 0;
        for(int i = low; i <= high; i++) aux[i] = array[i];
        int i = low;
        int j = mid + 1;
        for(int k = low; k <= high; k++){
            if(i > mid)       array[k] = aux[j++];
            else if(j > high) array[k] = aux[i++];
            else if(aux[i] <= aux[j]) array[k] = aux[i++];
            else {
                count += mid - i + 1;  //count the inversions
                array[k] = aux[j++];
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] array = new int[]{2, 4, 1, 3, 5};
        System.out.println(count(array));
    }

}
