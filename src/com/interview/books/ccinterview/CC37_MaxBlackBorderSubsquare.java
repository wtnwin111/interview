package com.interview.books.ccinterview;

/**
 * Created_By: stefanie
 * Date: 14-12-14
 * Time: 下午3:58
 */
public class CC37_MaxBlackBorderSubsquare {

    class Subsquare {
        int row;
        int col;
        int size;

        Subsquare(int row, int col, int size) {
            this.row = row;
            this.col = col;
            this.size = size;
        }
    }
    class SquareCell{
        int zerosRight = 0;
        int zerosBelow = 0;

        SquareCell(int zerosRight, int zerosBelow) {
            this.zerosRight = zerosRight;
            this.zerosBelow = zerosBelow;
        }
    }

    public Subsquare findMax(int[][] matrix){
        SquareCell[][] processed = processSquare(matrix);
        for(int i = matrix.length; i >= 1; i--){
            Subsquare square = findSquareSize(processed, i);
            if(square != null) return square;
        }
        return null;
    }

    private SquareCell[][] processSquare(int[][] matrix) {
        SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];

        for(int r = matrix.length - 1; r >= 0; r--){
            for(int c = matrix.length - 1; c >= 0; c--){
                int rightZero = 0;
                int belowZero = 0;
                if(matrix[r][c] == 0){
                    rightZero++;
                    belowZero++;
                    if(c + 1 < matrix.length)   rightZero += processed[r][c+1].zerosRight;
                    if(r + 1 < matrix.length)   belowZero += processed[r+1][c].zerosBelow;
                }
                processed[r][c] = new SquareCell(rightZero, belowZero);
            }
        }
        return processed;
    }


    private Subsquare findSquareSize(SquareCell[][] matrix, int size) {
        int count = matrix.length - size + 1;
        for(int row = 0; row < count; row++){
            for(int col = 0; col < count; col++){
                if(isSquare(matrix, row, col, size)) return new Subsquare(row, col, size);
            }
        }
        return null;
    }

    private boolean isSquare(SquareCell[][] matrix, int row, int col, int size){
        if(matrix[row][col].zerosRight < size) return false;  //topLeft
        if(matrix[row][col].zerosBelow < size) return false;
        if(matrix[row][col + size - 1].zerosBelow < size) return false; //topRight
        if(matrix[row + size - 1][col].zerosRight < size) return false; //bottomLeft
        return true;
    }

    public static void main(String[] args){
        CC37_MaxBlackBorderSubsquare finder = new CC37_MaxBlackBorderSubsquare();

        int[][] matrix = new int[][]{
                {0,1,1,0,0,0},
                {0,1,0,0,1,0},
                {0,0,0,0,0,0},
                {1,0,1,1,0,0},
                {0,0,1,0,0,0},
                {1,0,0,0,0,0}
        };
        Subsquare square = finder.findMax(matrix);
        System.out.println(square.row + ", " + square.col + ", size: " + square.size);

        matrix = new int[][]{
                {0,1,1,0,0,0},
                {0,1,0,0,1,0},
                {0,0,0,0,0,0},
                {1,0,1,1,0,0},
                {0,0,1,0,1,0},
                {1,0,0,0,0,0}
        };

        square = finder.findMax(matrix);
        System.out.println(square.row + ", " + square.col + ", size: " + square.size);
    }
}
