package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;

/**
 * Created_By: zouzhile
 * Date: 8/18/13
 * Time: 2:38 PM
 *
 * The problem:
 * Given an image represented by an N*N matrix,
 * where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 *
 *
 */
public class C4_1_ArrayRotation {

    public int[][] rotate(int[][] array) {
        return this.rotate(array, 0, 0);
    }

    /*
           a   b   c   d   e  f           A   B   C   D   E
           g   h   i   j   k  l           F   G   H   I   J
           m   n   o   p   q  r           K   L   M   N   O
           s   t   u   v   w  x           P   Q   R   S   T
           y   z   1   2   3  4           U   V   W   X   Y
           5   6   7   8   9  10
    Row based rotation, given current element is b:
    1) rotate b to l
    2) rotate l to 6
    3) rotate 6 to g
    4) rotate g to e
    Until the current sub array to rotate has a length smaller than 2, which means it's empty or has only 1 element
     */
    private int[][] rotate(int[][] array, int x, int y) {
//        System.out.println("Rotate: x=" + x + ", y=" + y);
        int subArrayLength = array.length - 2*y;
        if(subArrayLength < 2)
            return array;
        int subArrayEndingY = y + subArrayLength - 1;
        for(int j = y; j < subArrayEndingY; j++) {
            int targetX = this.getTargetOffsetX(array.length, x, j);
            int targetY = this.getTargetOffsetY(array.length, x, j);
            int temp = array[x][j];
            for(int count = 0; count < 4; count ++) {
                temp = rotateElement(array, temp, targetX, targetY);
                // recalculate the next target rotation position
                int newTargetX = this.getTargetOffsetX(array.length, targetX, targetY);
                int newTargetY = this.getTargetOffsetY(array.length, targetX, targetY);
                targetX = newTargetX;
                targetY = newTargetY;
            }
//            ConsoleWriter.printIntArray(array);
//            System.out.println("\t----------------");
        }
        return rotate(array, x+1, y+1);
    }

    private int rotateElement(int[][] array, int fromValue, int toX, int toY) {
        int temp = array[toX][toY];
        array[toX][toY] = fromValue;
        return temp;
    }

    private int getTargetOffsetX(int length, int x, int y) {
        return y;
    }

    private int getTargetOffsetY(int length, int x, int y) {
        return (length - 1 - x);
    }

    public static void run(int[][] array) {
        C4_1_ArrayRotation rotator = new C4_1_ArrayRotation();
        System.out.println("\nBefore Rotation:");
        ConsoleWriter.printIntArray(array);
        System.out.println("After Rotation:");
        ConsoleWriter.printIntArray(rotator.rotate(array));
    }
    public static void main(String[] args) {
        int[][] array = {{1}};
        run(array);
        array = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        run(array);
        array = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        run(array);
    }

}
