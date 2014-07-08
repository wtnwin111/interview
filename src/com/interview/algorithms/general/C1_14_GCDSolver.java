package com.interview.algorithms.general;

import com.interview.utils.ConsoleReader;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/8/14
 * Time: 2:00 PM
 */
public class C1_14_GCDSolver {
    public static int gcd(int i, int j){
        if(j > i) swap(i, j);
        while(i % j != 0){
            int mod = i % j;
            i = j;
            j = mod;
        }
        return j;
    }

    private static void swap(int i, int j){
        int temp = i;
        i = j;
        j = temp;
    }

    public static int gcdRecursive(int x, int y){
        if (x < y) {
            return gcdRecursive(y, x);
        }
        if(y == 0)
            return x;
        else
            return gcdRecursive(x % y, y);
    }

    public static void main(String[] args) {
        System.out.println("Greatest Common Divisor");
        System.out.println("========================================================================");
        ConsoleReader reader = new ConsoleReader();
        System.out.print("Plz input two integers : ");
        int[] inputs = reader.readIntItems();
        System.out.println("The greatest common divisor is: " + C1_14_GCDSolver.gcdRecursive(inputs[0], inputs[1]));
    }
}
