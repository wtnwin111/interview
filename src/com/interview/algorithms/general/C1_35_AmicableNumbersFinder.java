package com.interview.algorithms.general;

import com.interview.basics.model.collection.ArrayList;
import com.interview.basics.model.collection.List;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/11/14
 * Time: 5:12 PM
 */
class AmicableNumber{
    int num1;
    int num2;
    public AmicableNumber(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
}
public class C1_35_AmicableNumbersFinder {

    public static List<AmicableNumber> find(int range){
        List<AmicableNumber> numbers = new ArrayList<>();

        int N = range + 1;
        int[] sum = new int[N];

        for(int i = 0; i < N; i++) sum[i] = 1;

        for(int i = 2; i < N / 2; i++){
            for(int j = i + i; j < N; j += i){
                sum[j]+= i;
            }
        }

        for(int i = 1; i < N; i++){
           if(sum[i] < N && sum[i] > i && i == sum[sum[i]])
                numbers.add(new AmicableNumber(i, sum[i]));
        }

        return numbers;
    }
}
