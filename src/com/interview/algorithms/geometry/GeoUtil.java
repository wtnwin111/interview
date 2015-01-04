package com.interview.algorithms.geometry;

/**
 * Created_By: zouzhile
 * Date: 1/4/15
 * Time: 6:32 PM
 */
public class GeoUtil {

    /**
     * the dot product of vector AB and AC
     * @param A
     * @param B
     * @param C
     * @return
     */
    public static int dotProduct(int[] A, int[] B, int[] C) {
        int[] AB = new int[2];
        int[] AC = new int[2];
        AB[0] = B[0] - A[0];
        AB[1] = B[1] - A[1];
        AC[0] = C[0] - A[0];
        AC[1] = C[1] - A[1];
        return AB[0] * AC[0] + AB[1] * AC[1];
    }

    /**
     * the cross product of vector AB and AC
     * crossProduct(AB, AC) is AB x AC = |AB||AC|Sin(θ)
     *
     * @param A
     * @param B
     * @param C
     * @return
     */
    public static int crossProduct(int[] A, int[] B, int[] C) {
        int[] AB = new int[2];
        int[] AC = new int[2];
        AB[0] = B[0] - A[0];
        AB[1] = B[1] - A[1];
        AC[0] = C[0] - A[0];
        AC[1] = C[1] - A[1];
        return AB[0] * AC[1] - AB[1] * AC[0];
    }

    /**
     * the size of vector AB
     * @param A
     * @param B
     * @return
     */
    public static double size(int[] A, int[] B) {
        int[] AB = new int[2];
        AB[0] = B[0] - A[0];
        AB[1] = B[1] - A[1];
        return Math.sqrt(AB[0] * AB[0] + AB[1] * AB[1]);
    }

}
