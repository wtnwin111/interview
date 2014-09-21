package com.interview.algorithms.general;

/**
 * Created_By: stefanie
 * Date: 14-9-21
 * Time: 下午1:35
 */
public class C1_60_CountRelations {
    static class Relation {
        int r1;
        int r2;

        Relation(int r1, int r2) {
            this.r1 = r1;
            this.r2 = r2;
        }
    }

    public static Relation count(int N){
        int[] r1s = new int[N + 1];
        int[] r2s = new int[N + 1];
        r1s[1] = 0;
        r2s[1] = 0;
        for(int i = 2; i <= N; i++) r1s[i] = 3 * r1s[i-1] + (int) Math.pow(2, i-1) - 1;
        for(int i = 2; i <= N; i++) r2s[i] = 3 * r2s[i-1] + 3 * r1s[i-1];
        return new Relation(r1s[N],r2s[N]);
    }
}
