package com.interview.algorithms.general;

/**
 * Created_By: stefanie
 * Date: 14-7-23
 * Time: 下午10:08
 */
public class C1_37_NContainsOneNumber {
//    public static int number(int N){
//        return number(N, 1, 0, 1, 0, 0);
//    }

    public static int number(int N) {
        int SIZE = 10;
        int[] digits = new int[SIZE];
        int[] full_count = new int[SIZE];
        int[] low_number = new int[SIZE];

        int times = 1;
        int base = N;
        int i = 1;
        full_count[0] = 0;
        full_count[1] = 1;
        low_number[0] = 0;
        while (base > 0) {
            digits[i] = base % 10;
            low_number[i] = digits[i] * times;
            if (i > 0) {
                low_number[i] += low_number[i - 1];
                full_count[i] = 10 * full_count[i - 1] + times;
            }
            base = base / 10;
            times = times * 10;
            i++;
        }

        int count = 0;
        int j = 1;
        times = 1;
        while (j < i) {
            if (digits[j] > 1) {
                count += times + digits[j] * full_count[j - 1];
            } else if (digits[j] == 1) {
                count += low_number[j - 1] + 1 + full_count[j - 1];
            }
            times = times * 10;
            j++;
        }
        return count;
    }

    public static int numberRecursive(int n){
        return number(n, 1, 0, 0);
    }

    private static int number(int n, int times, int low_number, int full_count) {
        int mod = n % 10;
        int count = 0;
        if (n / 10 > 0) {
            count += number(n / 10, times * 10, mod * times + low_number, 10 * full_count + times);
        }
        if (mod > 1) {
            count += times + mod * full_count;
        } else if (mod == 1) {
            count += low_number + 1 + full_count;
        }
        return count;
    }

    public static int numberLoop(int n){
        int count = 0;
        int times = 1;
        int low_number = 0;
        int full_count = 0;
        while(n > 0){
            int mod = n % 10;
            if (mod > 1) {
                count += times + mod * full_count;
            } else if (mod == 1) {
                count += low_number + 1 + full_count;
            }
            n = n /10;
            low_number = mod * times + low_number;
            full_count = 10 * full_count + times;
            times = times * 10;
        }
        return count;
    }

    public static int correctAnswer(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            String st = String.valueOf(i);
            for (int j = 0; j < st.length(); j++) {
                if (st.charAt(j) == '1') count++;
            }
        }
        return count;
    }
}
