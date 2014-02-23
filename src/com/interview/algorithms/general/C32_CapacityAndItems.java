package com.interview.algorithms.general;

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
        Status status = new Status();
        status.packsCount = new int[packs.length];
        getPacksCount(N, packs, status, 0);
    }

    class Status {
        int sum = 0;
        int[] packsCount;
        int code = -1;
    }

    public void getPacksCount(int N, int[] packs, Status status, int type) {

        if(status.sum > N){
            status.code = 1;
            return;
        }

        if(status.sum == N) {
            printCombination(packs, status.packsCount, status.sum);
            status.code = 0;
            return;
        }

        // given current packsCount[type]
        // the for loop try with more packs[type] or the types after the given "type"
        // i.e. look down or right.
        for(int i = type; i < packs.length; i ++) {
            // put in pack[i]
            status.packsCount[i] += 1;
            status.sum += packs[i];
            this.getPacksCount(N, packs, status, i);
            if(status.code >= 0) {
                // when the last pack make the sum equal or bigger than N,
                // move out the last pack to try other packs
                status.sum -= packs[i];
                status.packsCount[i] -= 1; // take out pack[i]
            }
        }

        // try with 1 less packs[type] and then look at right side by recursion after line 72
        status.packsCount[type] --;
        status.sum -= packs[type];
        status.code = -1;
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
