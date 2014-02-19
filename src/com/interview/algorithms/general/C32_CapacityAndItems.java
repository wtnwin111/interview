package com.interview.algorithms.general;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 14-2-19
 * Time: 上午8:43
 * To change this template use File | Settings | File Templates.
 *
 * Shopkeeper want sells in the packs of 20,9 and 6.
 * Given an n, you need to find whether its possible to buy the items or not.
 * For example n=21, you can buy 2 packs of 6 and one pack of 9(2*6 + 9)
 */
public class C32_CapacityAndItems {

    public boolean check(int N, int[] packs) {
        return check(N, 0, packs);
    }

    public boolean check(int N, int currentSum, int[] packs) {
        if(currentSum > N)
            return false;
        if(currentSum == N)
            return true;
        for(int i = 0; i < packs.length; i ++) {
            if(this.check(N, currentSum + packs[i], packs))
                return true;
        }
        return false;
    }

    /**
     * If N can buy the items with the given packs, get the amount of each pack
     * @param N
     * @param packs
     * @return
     */
    public void getPacksAmount(int N, int[] packs) {
        int[] packsCount = new int[packs.length];
        getPacksCount(N, packs, 0, packsCount, 0);
    }

    public int getPacksCount(int N, int[] packs, int currentSum, int[] packsCount, int index) {

        if(currentSum > N)
            return 1;

        if(currentSum == N) {
            printCombination(packs, packsCount, currentSum);
            return 0;
        }


        // current sum < N, try to put in more packs
        // the input packsCount shouldn't be changed on return
        int[] packsCountCopy = Arrays.copyOf(packsCount, packsCount.length);
        for(int i = index; i < packs.length; i ++) {
            // put in pack[i]
            packsCountCopy[i] += 1;
            currentSum += packs[i];

            int status = this.getPacksCount(N, packs, currentSum, packsCountCopy, i);
            if(status >= 0) {
                // when the last pack make the sum equal or bigger than N,
                // move out the last pack to try other packs
                currentSum -= packs[i];
                packsCountCopy[i] -= 1; // take out pack[i]
            }
        }
        return -1;
    }

    private void printCombination(int[] packs, int[] packsCount, int sum) {
        for(int i = 0; i < packs.length; i ++)
            System.out.print("\t" + packs[i] + ":" + packsCount[i]);
        System.out.print("\tsum=" + sum);
        System.out.println();
    }


    public static void main(String[] args) {
        C32_CapacityAndItems checker = new C32_CapacityAndItems();
        int N = 42;
        int[] packs = new int[]{6, 9, 20};
        String packString = "";
        for(int pack : packs)
            packString += pack + " ";
        System.out.println("N = " + N + ", packs = " + packString);
        System.out.println("Can buy: " + checker.check(N, packs));
        System.out.println("Combinations:");
        checker.getPacksAmount(N, packs);
    }

}
