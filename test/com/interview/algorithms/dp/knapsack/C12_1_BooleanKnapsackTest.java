package com.interview.algorithms.dp.knapsack;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created_By: zouzhile
 * Date: 3/7/14
 * Time: 10:28 AM
 */
public class C12_1_BooleanKnapsackTest {

    @Test
    public void testRecursionBasedBooleanKnapsack() {

        int[] weights = new int[]{6, 9, 20};
        int[] values = new int[] {2, 4, 7};
        int W = 30;
        C12_1_BooleanKnapsack knapsack = new C12_1_BooleanKnapsack();
        int maxValue = knapsack.getMaxValueByRecursion(weights.length - 1, W, weights, values);
        Assert.assertEquals(maxValue, 11);
    }

    @Test
    public void testDynamicProgrammingBasedBooleanKnapsack(){
        int[] weights = new int[]{6, 9, 20};
        int[] values = new int[] {2, 4, 7};
        int W = 30;
        C12_1_BooleanKnapsack knapsack = new C12_1_BooleanKnapsack();
        int maxValue = knapsack.getMaxValueByDynamicProgramming(W, weights, values);
        Assert.assertEquals(maxValue, 11);
    }


}
