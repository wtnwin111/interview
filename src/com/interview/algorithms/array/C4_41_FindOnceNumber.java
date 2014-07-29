package com.interview.algorithms.array;

/**
 * Created_By: stefanie
 * Date: 14-7-29
 * Time: 下午10:38
 */

class Result{
    int n1;
    int n2;
    public Result(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
    }
}

public class C4_41_FindOnceNumber {

    public static Result find(int[] array){
        int s = 0;
        for(int i = 0; i < array.length; i++)  s ^= array[i];

        int temp1 = s;
        int temp2 = s;
        int k = 0;
        while((temp1&1) == 0){        //get lowest 1 number, that means in this bit, n1 != n2
            temp1 = temp1 >> 1;
            k++;
        }
        for(int i=0; i<array.length; i++){  //only XOR number follow the same condition with n1 to find n2
            if(((array[i]>>k)&1) == 1){
                temp2 ^= array[i];
            }
        }
        return new Result(temp2, s^temp2);
    }
}
