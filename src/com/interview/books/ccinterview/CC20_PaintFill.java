package com.interview.books.ccinterview;

import com.interview.utils.ConsoleWriter;

/**
 * Created_By: stefanie
 * Date: 14-12-13
 * Time: 下午7:54
 */
public class CC20_PaintFill {
    public void paint(int[][] matrix, int x, int y, int color){
        if(matrix == null || matrix.length == 0) return;
        if(!withinMatrix(matrix, x, y) || matrix[x][y] == color) return;
        paint(matrix, x, y, matrix[x][y], color);
    }
    
    private void paint(int[][] matrix, int x, int y, int original, int color){
        if(!withinMatrix(matrix, x, y) || matrix[x][y] != original) return;
        matrix[x][y] = color;
        paint(matrix, x + 1, y, original, color);
        paint(matrix, x - 1, y, original, color);
        paint(matrix, x, y + 1, original, color);
        paint(matrix, x, y - 1, original, color);
    }
    
    private boolean withinMatrix(int[][] matrix, int x, int y){
        if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) return true;
        else return false;
    }
    
    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1,2,2,2,4,5,6},
                {4,3,2,4,4,4,7},
                {1,2,3,4,5,6,7}
        };
        CC20_PaintFill painter = new CC20_PaintFill();
        painter.paint(matrix, 1, 3, 7);
        ConsoleWriter.printIntArray(matrix);
    }
}
