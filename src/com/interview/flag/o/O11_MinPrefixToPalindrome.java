package com.interview.flag.o;

/**
 * Created_By: stefanie
 * Date: 15-1-15
 * Time: 上午11:00
 */
public class O11_MinPrefixToPalindrome {
    public String getPrefix(String S){
        StringBuffer buffer = new StringBuffer();
        int back = S.length() - 1;
        int front = back;
        int head = 0;
        while(front > head){
            while(front > head && S.charAt(front) == S.charAt(head)){
                front--;
                head++;
            }
            if(front <= head) break;

            while(back >= front)buffer.append(S.charAt(back--));
            front--;
            head = 0;
        }
        return buffer.toString();
    }

    public static void main(String[] args){
        O11_MinPrefixToPalindrome finder = new O11_MinPrefixToPalindrome();
        System.out.println(finder.getPrefix("ababc"));
        System.out.println(finder.getPrefix("abacabc"));
    }
}
