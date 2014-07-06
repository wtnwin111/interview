package com.interview.algorithms.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created_By: stefanie
 * Date: 14-7-6
 * Time: 下午9:41
 *
 * Write a algorithm such that if an element in an element in a M*N matrix is 0, it's entire row and column is set to 0.
 *
 * Solution:
 *      1. Scan the matrix and make the rows and column need be reset.
 *      2. Reset the column. To avoid duplicate reset, first reset the rows and mark non-zero rows, every column just reset the non-zero rows.
 *
 *      Time: O(M*N)    Space: O(N+M)
 */
public class C4_28_ResetMatrix {

    public static int[][] reset(int[][] matrix){
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        Set<Integer> nonZeroRows = new HashSet<Integer>();
        for(int i = 0; i < rows.length; i++){
            if(rows[i]){
                for(int m = 0; m < matrix[i].length; m++) matrix[i][m] = 0;
            } else {
                nonZeroRows.add(i);
            }
        }
        for(Integer n : nonZeroRows){
            for(int j = 0; j < columns.length; j++){
                if(columns[j])  matrix[n][j] = 0;
            }
        }
        return matrix;
    }
}
