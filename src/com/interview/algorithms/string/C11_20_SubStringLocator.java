package com.interview.algorithms.string;

/**
 * Created_By: stefanie
 * Date: 14-7-20
 * Time: 下午2:45
 */
public class C11_20_SubStringLocator {

    public static int match(String a, String b){
        for(int i = 0; i < a.length(); i++) {
            int j = 0;
            for (; j < b.length() && b.charAt(j) == a.charAt(i + j); j++);
            if (j >= b.length()) return i;
        }
        return -1;
    }

    public static int kmpMatch(String a, String b){
        int[] next = calNext(b);
        int i = 0, j = 0;
        while(i < a.length() && j < b.length()){
            if(b.charAt(j) == a.charAt(i)){
                i++;
                j++;
            } else if(j == 0) {
                i++;
            } else j = next[j-1] + 1;
            if(j == b.length()) return i - j;
        }
        return -1;
    }

    private static int[] calNext(String b){
        int[] next = new int[b.length()];
        next[0] = -1;
        for(int i = 1; i < b.length(); i++){
            int j = i - 1;
            for(; j >= 0 && b.charAt(i) != b.charAt(j); j--);
            if(j < 0) next[i] = -1;
            else next[i] = j;
        }
        return next;
    }

    public static int bmMatch(String a, String b){
        int[] D = calD(b);
        int i = b.length() - 1, j = 0, k = 0;
        while(j >= 0 && i < a.length()){
            j = b.length() - 1;
            k = i;
            while(j >= 0 && a.charAt(k) == b.charAt(j)){
                j--;
                k--;
            }
            i+= D[a.charAt(i) - 'a'];
        }
        if(j < 0) return k + 1;
        else return -1;
    }

    private static int[] calD(String b){
        int[] D = new int[26];
        int M = b.length();
        for(int i = 0; i < 26; i++) D[i] = M;
        for(int i = M-2; i >= 0; i--)
            if(D[b.charAt(i) - 'a'] == M)  D[b.charAt(i) - 'a'] = M - i - 1;

        return D;
    }
}
