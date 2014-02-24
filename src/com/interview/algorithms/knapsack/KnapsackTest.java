package com.interview.algorithms.knapsack;

/**
 * Created_By: zouzhile
 * Date: 2/23/14
 * Time: 5:02 PM
 */
public class KnapsackTest {

    public static void testBooleanKnapsack(int W, int[] weights, int[] values){
        System.out.println("\nBoolean Knapsack");
        Knapsack knapsack = new BooleanKnapsack();
        System.out.println("\tMax Value: " + knapsack.getMaxValue(W, weights, values));
    }


    public static void main(String[] args) {
        int[] weights = new int[]{6, 9, 20};
        int[] values = new int[] {2, 4, 7};
        int W = 30;
        System.out.println("Test Data: ");
        System.out.println("\tW = " + W);
        printArray(weights, "weights");
        printArray(values, "values ");

        testBooleanKnapsack(W, weights, values);
    }

    public static void printArray(int[] array, String name) {
        System.out.print("\t" + name + ":");
        for(int a : array) {
            System.out.print(" " + a);
        }
        System.out.println();
    }
}
