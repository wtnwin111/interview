package com.interview.books.leetcode;

/**
 * Created_By: stefanie
 * Date: 14-12-11
 * Time: 下午9:42
 */
public class LCS19_ReorderStringDDistance {
    public String reorder(String base, int d){
        int[] freq = new int[256];
        for(int i = 0; i < base.length(); i++) freq[base.charAt(i)]++;

        int[] distance = new int[256];
        char[] ans = new char[base.length()];
        for (int i = 0; i < base.length(); i++){
            int j = findMaxFreq(freq, distance);

            if (j == -1){
                return "Error";
            }

            ans[i] = (char)j;
            freq[j]--;
            distance[j] = d;

            for (int k = 0; k < 256; k++)   distance[k]--;
        }
        return String.valueOf(ans);
    }

    private int findMaxFreq(int freq[], int[] distance) {
        int max_i = -1;
        int max = 0;

        for (char c = 'a'; c <= 'z'; c++){
            if ((distance[c] <= 0 && freq[c] > max)){
                max_i = c;
                max = freq[c];
            }
        }
        return max_i;
    }

    public static void main(String[] args){
        LCS19_ReorderStringDDistance changer = new LCS19_ReorderStringDDistance();
        System.out.println(changer.reorder("abbb", 2));
        System.out.println(changer.reorder("efabcadf", 4));
    }
}
