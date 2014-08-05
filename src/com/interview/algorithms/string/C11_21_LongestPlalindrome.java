package com.interview.algorithms.string;

/**
 * Created_By: stefanie
 * Date: 14-8-4
 * Time: 下午9:41
 *
 * Also can be solve using Suffix Tree: http://m.blog.csdn.net/blog/beyond_boy/8066447
 */
public class C11_21_LongestPlalindrome {

    //Solution: http://blog.csdn.net/ggggiqnypgjg/article/details/6645824
    public static String findOptimized(String str){
        char[] chars = new char[str.length()*2 -1];
        chars[0] = str.charAt(0);
        for(int i = 1; i < str.length(); i++){
            chars[i*2 -1] = '#';
            chars[i*2] = str.charAt(i);
        }

        int mx = 0, id = 0;
        int[] p = new int[chars.length];
        for (int i = 1; i < chars.length; i++) {
            p[i] = mx > i ? Math.min(p[2*id-i], mx-i) : 1;
            while (i-p[i] >= 0 && i + p[i] < chars.length && chars[i + p[i]] == chars[i - p[i]]) p[i]++;
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
        }
        int maxP = 0;
        for(int i = 1; i < p.length; i++) {
            if(p[i] > p[maxP]) maxP = i;
        }

        int length = p[maxP];
        int pos = (maxP - length) % 2 == 0? 2 : 1;
        char[] pChars = new char[length - pos / 2];
        for(int i = 0; i < pChars.length; i++){
            pChars[i] = chars[(maxP - length) + 2 * i + pos];
        }
        return String.copyValueOf(pChars);
    }

    public static String find(String str){
        int longest = 1;
        int begin = 0;
        int end = 0;
        for(int i = 0; i < str.length() - 1 && str.length() - i > longest; i++){
            int p = i;
            int q = str.length() - 1;
            int count = 0;
            while(p <= q){
                if(str.charAt(p) != str.charAt(q)) {
                    p = i;
                    count = 0;
                } else {
                    p++;
                    count++;
                }
                q--;
            }
            if(count > longest) {
                longest = count;
                begin = p - count;
                end = q + count + 1;
            }
        }
        return str.substring(begin, end);
    }


}
