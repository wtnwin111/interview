package com.interview.algorithms.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-10-26
 * Time: 下午6:26
 */
public class C1_69_NParentheses {
    public static List<String> find(int n){
        List<String> sol = new ArrayList<String>();
        find(sol, n, n, new char[2 * n], 0);
        return sol;
    }

    private static void find(List<String> sol, int left, int right, char[] cur, int count){
        if(left < 0 || right < left) return;
        if(left == 0 && right == 0) sol.add(String.copyValueOf(cur));
        else {
            if(left > 0){
                cur[count] = '(';
                find(sol, left - 1, right, cur, count + 1);
            }
            if(right > left){
                cur[count] = ')';
                find(sol, left, right - 1, cur, count + 1);
            }
        }
    }
}
