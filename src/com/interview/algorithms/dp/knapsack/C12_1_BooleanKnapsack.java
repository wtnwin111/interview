package com.interview.algorithms.dp.knapsack;

/**
 * Created_By: zouzhile
 * Date: 2/23/14
 * Time: 5:02 PM
 */
public class C12_1_BooleanKnapsack implements C12_1_Knapsack {

    @Override
    public int getMaxValue(int W, int[] weights, int[] values) {
        //return this.getMaxValueByRecursion(weights.length - 1, W, weights, values);
        return this.getMaxValueByDynamicProgramming(W, weights, values);
    }

    protected int getMaxValueByRecursion(int index, int W, int[] weights, int[] values) {
        if(index < 0)
            return 0;
        if(weights[index] > W) {
            return getMaxValueByRecursion(index - 1, W, weights, values);
        } else {
            return Math.max(this.getMaxValueByRecursion(index - 1, W, weights, values),
                    this.getMaxValueByRecursion(index - 1, W - weights[index], weights, values) + values[index]);
        }
    }

    protected int getMaxValueByDynamicProgramming(int W, int[] weights, int[] values) {
        int N = weights.length; // the number of item types

        weights = this.shift(weights);
        values = this.shift(values);

        // opt[n][w] = max profit of packing items 1..n with weight limit w
        // sol[n][w] = does opt solution to pack items 1..n with weight limit w include item n?
        int[][] opt = new int[N+1][W+1];
        boolean[][] sol = new boolean[N+1][W+1];

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {

                // don't take item n
                int option1 = opt[n-1][w];

                // take item n
                int option2 = Integer.MIN_VALUE;
                if (weights[n] <= w)
                    option2 = values[n] + opt[n-1][w-weights[n]];

                // select better of two options
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);
            }
        }

        return opt[N][W];
    }

    private int[] shift(int[] array){
        int[] result = new int[array.length + 1];
        for(int i = 0; i < array.length; i++)
            result[i+1] = array[i];
        result[0] = 0;
        return  result;
    }
}
