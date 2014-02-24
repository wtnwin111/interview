package com.interview.algorithms.knapsack;

/**
 * http://en.wikipedia.org/wiki/Knapsack_problem
 * http://zh.wikipedia.org/wiki/%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98
 * @author zouzhile
 *
 */
public interface Knapsack {

    public int getMaxValue(int W, int[] weights, int[] values);

}
