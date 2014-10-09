package com.interview.algorithms.array;

/**
 * Created_By: stefanie
 * Date: 14-10-9
 * Time: 上午10:21
 */
public class C4_64_MaxSubSquareBlackBorder {

    static class Result {
        int x = 0;
        int y = 0;
        int columns = 0;
        int rows = 0;
    }

    public static Result find(int[][] array) {
        Result result = new Result();
        for (int i = 0; i < array.length - 1; i++) // rows
            for (int j = 0; j < array[0].length - 1; j++) // columns
                find(array, i, j, result);
        return result;
    }

    private static void find(int[][] array, int x, int y, Result result) {
        if (array[x][y] == 0 || array[x + 1][y] == 0 || array[x][y + 1] == 0)
            return;
        int rowSpan = 0;
        int columnSpan = 0;

        // going top to down
        while (rowSpan < array.length - 1 && array[x + rowSpan][y] == 1)
            rowSpan += 1;

        // going left to right
        while (columnSpan < array[0].length - 1 && array[x][y + columnSpan] == 1)
            columnSpan += 1;

        for (int i = 1; i <= rowSpan; i++) {
            for (int j = 1; j <= columnSpan; j++)
                find(array, x, y, x + i, y + j, result);
        }

    }


    private static void find(int[][] array, int x, int y, int x1, int y1, Result result) {
        for (int i = x1; i > x; i--)
            if (array[i][y1] == 0)
                return;
        for (int j = y1; j > y; j--)
            if (array[x1][j] == 0)
                return;

        if ((x1 - x + 1) * (y1 - y + 1) > result.columns * result.rows) {
            result.x = x;
            result.y = y;
            result.columns = y1 - y + 1;
            result.rows = x1 - x + 1;
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{0, 1, 1, 1, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}};
        Result result = find(array);
        System.out.println(String.format("x=%s, y=%s, rows=%s, columns=%s", result.x, result.y, result.rows, result.columns));
    }

}
