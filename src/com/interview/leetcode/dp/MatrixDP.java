package com.interview.leetcode.dp;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-24
 * Time: 下午9:23
 */
public class MatrixDP {
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     */
    //Time: O(N), Space: O(1)
    public int climbStairs(int n) {
        int[] ways = new int[3];
        ways[0] = 1;
        ways[1] = 2;
        for(int i = 2; i < n; i++){
            ways[i%3] = ways[(i - 2)%3] + ways[(i - 1)%3];
        }
        return ways[(n - 1)%3];
    }

    /**
     * Given a grid, and some obstacles are added.
     * How many unique paths would there be from 0.0 to m.n?
     */
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        path[0][0] = grid[0][0] == 1? 0 : 1;
        for(int i = 1; i < m; i++) path[i][0] = grid[i][0] == 1? 0 : path[i - 1][0];
        for(int i = 1; i < n; i++) path[0][i] = grid[0][i] == 1? 0 : path[0][i - 1];
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                path[i][j] = grid[i][j] == 1? 0 : path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
    }

    /**
     * Given a triangle of int numbers. Find the min path from the top to the bottom
     *  State: path[i][j] the path sum of j-th element from 0 layer to i-th layer
     *  Transfer: path[i][j] = Math.min(path[i-1][j], path[i-1][j-1])
     *  Init: path[0][0] = element in layer 0
     *  Result: the min path in layer n
     */
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
