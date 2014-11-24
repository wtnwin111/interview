package com.interview.leetcode.dp;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-24
 * Time: 下午8:02
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int layer = triangle.size();
        int[] path = new int[layer];
        path[0] = triangle.get(0).get(0);
        for(int i = 1; i < layer; i++){
            List<Integer> current = triangle.get(i);
            for(int j = current.size() - 1; j >= 0; j--){
                if(j == current.size() - 1) path[j] = path[j - 1] + current.get(j);
                else if(j == 0)             path[j] = path[j] + current.get(j);
                else                        path[j] = Math.min(path[j - 1], path[j]) + current.get(j);
            }
        }
        int min = path[0];
        for(int i = 1; i < path.length; i++){
            if(path[i] < min) min = path[i];
        }
        return min;
    }
}
