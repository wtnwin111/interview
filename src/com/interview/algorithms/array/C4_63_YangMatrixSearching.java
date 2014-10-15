package com.interview.algorithms.array;

import com.interview.utils.models.Point;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 10/15/14
 * Time: 4:42 PM
 *
 * http://blog.csdn.net/zhanglei8893/article/details/6234564
 */
public class C4_63_YangMatrixSearching {

    public static boolean exist(int[][] matrix, int k){
        int n = matrix[0].length - 1;
        int m = matrix.length - 1;
        if(k < matrix[0][0] || k > matrix[n][m]) return false;
        return exist(matrix, new Point(0,0), new Point(n, m), k);
    }

    public static boolean exist(int[][] matrix, Point i, Point j, int k){
        if(i.x == j.x && i.y == j.y){
            if(k == value(matrix, i)) return true;
            else return false;
        } else {
            Point[] points = middle(i, j);
            if(k == value(matrix, points[0]) || k == value(matrix, points[1])) return true;
            else if(k < value(matrix, points[0])) return exist(matrix, i, points[0], k);
            else if(k > value(matrix, points[1])) return exist(matrix, points[1], j, k);
            else {
                return exist(matrix, new Point(i.x, points[1].y), new Point(points[0].x, j.y), k)
                        | exist(matrix, new Point(points[1].x, i.y), new Point(j.x, points[0].y), k);
            }
        }
    }

    private static int value(int[][] matrix, Point i){
        return matrix[i.x][i.y];
    }

    private static Point[] middle(Point i, Point j){
        int gapY = (j.y - i.y) >> 1;
        int gapX = (j.x - i.x) >> 1;
        Point[] points = new Point[2];
        points[0] = new Point(i.x + gapX, i.y + gapY);
        points[1] = new Point(i.x + gapX + 1, i.y + gapY + 1);
        return points;
    }
}
