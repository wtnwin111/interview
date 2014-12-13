package com.interview.books.ccinterview;

/**
 * Created_By: stefanie
 * Date: 14-12-13
 * Time: 下午11:00
 */
public class CC25_MaxWithComparison {

    public static int getMax(int a, int b){
        int c = a - b;

        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int use_sign_of_a = sa ^ sb;
        int use_sign_of_c = (sa ^ sb) ^ 1;

        //if a and b have different sign, k = sign(a), if a and b have same sign, k = sign(a-b).
        int k = use_sign_of_a * sa + use_sign_of_c * sc;
        int q = k ^ 1;

        return a * k + b * q;
    }

    public static int sign(int a){
        return ((a >> 31) & 1) ^ 1;
    }
}
