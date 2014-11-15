package com.interview.leetcode.arrays.matrix;

/**
 * Created_By: stefanie
 * Date: 14-11-15
 * Time: 下午3:51
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 *
 * Tricks:
 *  1. settle right-up point, and find the max matrix we could get.
 *  2. when find max matrix, first find the max rows and max cols, then shrink if some rule (have 0) is broken.
 *  3. tracking max during the searching.
 */
public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        int max = 0;
        for(int i = 0; i < matrix.length; i ++)
            for(int j = 0; j < matrix[0].length; j ++) {
                int area = getArea(matrix, i, j);
                if(area > max) max = area;
            }
        return max;
    }

    private static int getArea(char[][] matrix, int x, int y) {
        if(matrix[x][y] == '0') return 0;
        int rows = 1;
        int cols = 1;
        int area = 1;
        for(int i = x + 1; i < matrix.length && matrix[i][y] == '1'; i ++) rows += 1;
        area = rows;
        for(int j = y + 1; j < matrix[0].length && matrix[x][j] == '1'; j ++) cols += 1;
        if(cols > rows) area = cols;

        // shrinking cols
        for(int i = x + 1; i < x + rows; i ++) {
            for(int j = y + 1; j < y + cols; j ++) {
                if(matrix[i][j] == '0') {
                    int currCols = j - y;
                    if(currCols < cols) cols = currCols;
                    break;
                }
            }
            int currRows = i - x + 1;
            if(currRows * cols > area) area = currRows * cols;
        }
        return area;
    }

//
//    public static int maximalRectangleDP(char[][] matrix) {
//        if(matrix.length == 0) return 0;
//
//        int max = 0;
//        int[] rows = new int[matrix[0].length];
//        int[] cols = new int[matrix[0].length];
//
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[0].length; j++){
//                if(matrix[i][j] == '0'){
//                    rows[j] = 0;
//                    cols[j] = 0;
//                } else {
//                    rows[j] = i > 0? rows[j] + 1 : 1;
//                    cols[j] = j > 0? cols[j-1] + 1 : 1;
//                    int area = rows[j] * cols[j];
//                    if(area > max) max = area;
//                }
//            }
//        }
//        return max;
//    }
}
