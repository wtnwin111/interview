package com.interview.algorithms.graph;

import com.interview.utils.ArrayUtil;
import junit.framework.TestCase;

public class C6_18_SudokuGameTest extends TestCase {

    /**
     *      5 4 1           1 2 3
     *      3   2   --->    8   4
     *      7 8 6           7 6 5
     * @throws Exception
     */
    public void testSolve() throws Exception {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{5, 4, 1};
        matrix[1] = new int[]{3, 0, 2};
        matrix[2] = new int[]{7, 8, 6};

        int[] ops = C6_18_SudokuGame.solve(matrix);
        int x = 1;
        int y = 1;
        for(int op : ops){
            switch (op){
                case 0: //up
                    ArrayUtil.swap(matrix, x, y, --x, y);
                    break;
                case 1: //down
                    ArrayUtil.swap(matrix, x, y, ++x, y);
                    break;
                case 2: //left
                    ArrayUtil.swap(matrix, x, y, x, --y);
                    break;
                case 3:
                    ArrayUtil.swap(matrix, x, y, x, ++y);
            }
        }

        assertTrue(checkFinish(matrix));
    }

    public boolean checkFinish(int[][] matrix){
        return (matrix[0][0] == 1 && matrix[0][1] == 2 && matrix[0][2] == 3
            && matrix[1][0] == 8 && matrix[1][2] == 4
            && matrix[2][0] == 7 && matrix[2][1] == 6 && matrix[2][2] == 5);
    }
}