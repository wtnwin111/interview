package com.interview.algorithms.array;

import com.interview.utils.ArrayUtil;

/**
 * Created_By: stefanie
 * Date: 14-11-12
 * Time: 下午5:41
 */
public class C1_81_FirstMissingPositive {

    public static int firstMissingPositive(int[] num) {
        if(num.length == 0) return 1;
        for(int i = 0; i < num.length;){
            if(num[i] > 0 && num[i] <= num.length && num[i] != i + 1 && num[i] != num[num[i] - 1]){
                ArrayUtil.swap(num, i, num[i] - 1);
            } else i++;
        }
        for(int i = 0; i < num.length; i++){
            if(num[i] != i + 1) return i + 1;
        }
        return num.length + 1;
    }
}
