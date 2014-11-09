package com.interview.algorithms.string;

/**
 * Created_By: stefanie
 * Date: 14-11-9
 * Time: 下午8:45
 */
public class C11_36_DecodeWays {
    public static int numDecoding(String s) {
        if(s.length() == 0) return 0;
        int[] sols = new int[s.length()];     //to avoid duplicated calculation
        return numDecoding(s, 0, sols);
    }

    private static int numDecoding(String s, int offset, int[] sols){
        if(offset < s.length() - 1){     //have more than one char, recursive calling
            if(sols[offset] != 0) return sols[offset];
            char cur = s.charAt(offset);
            char next = s.charAt(offset + 1);
            if(cur == '0') return 0;  //invalid case
            else if(next == '0'){      // 10... or 40...
                if(cur != '1' && cur != '2') return 0;    //invalid case, such 40
                else sols[offset] = numDecoding(s, offset + 2, sols);  //valid case, 10 or 20, can only move 2 steps
            } else if(cur > '2' || cur == '2' && next > '6'){ // > 26, can't be together with next, can only move 1 steps
                sols[offset] = numDecoding(s, offset + 1, sols);
            } else { // < 26, move 1 or 2 steps
                sols[offset] = numDecoding(s, offset + 1, sols) + numDecoding(s, offset + 2, sols);
            }
            return sols[offset];
        } else if(offset == s.length() - 1) return (s.charAt(offset) == '0')? 0 : 1;  //have only one char
        else return 1;  //reach the end of str, have decode all the chars,
    }
}
