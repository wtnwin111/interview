package com.interview.algorithms.general;

/**
 * Created_By: stefanie
 * Date: 14-7-23
 * Time: 下午10:08
 */
public class C1_37_NContainsOneNumber {
    public static int number(int N){
        return number(N, 1, 0, 1, 0, 0);
    }

    private static int number(int N, int exp, int lower, int times, int low_count, int full_count){
        int mod = N % 10;
        int count = 0;
        if(mod > 1) {
            count+= exp;
            full_count = count;
        }
        else if(mod == 1) count+= lower+1+low_count+full_count;
        else if(mod < 1) count+= low_count;
        if(N/10 > 0){
            lower = mod * times + lower;
            count+= number(N/10, exp*10, lower, times+1, count, full_count) * exp;
        }
        return count;
    }

    public static int countOf1s(int n) {
        int[] prefix = new int[10];
        int[] suffix = new int[10];
        int[] digits = new int[10]; //10 is enough for 32bit integers int i=0;
        int base = 1;
        int i = 0;
        while (base < n) {
            suffix[i] = n % base;
            digits[i] = (n % (base * 10)) - suffix[i];
            prefix[i] = (n - suffix[i] - digits[i]*base)/10;
            i++;
            base*=10;
        }
        int count = 0;
        base = 1;
        for (int j=0; j<i; j++) {
            if (digits[j] < 1) count += prefix[j];
            else if (digits[j]==1) count += prefix[j] + suffix[j] + 1;
            else count += prefix[j] + base;
            base *= 10;
        }
        return count;
    }
}
