package com.interview.algorithms.dp;

/**
 * Created_By: zouzhile
 * Date: 3/27/14
 * Time: 6:16 PM
 */
public class C12_7_FlowerGarden {

    public int[] getOrdering(int[] height, int[] bloom, int[] wilt) {
        int[] optimal = new int[height.length];
        int[] optimalBloom = new int[bloom.length];
        int[] optimalWilt = new int[wilt.length];

        // init state
        optimal[0] = height[0];
        optimalBloom[0] = bloom[0];
        optimalWilt[0] = wilt[0];

        // run dynamic programming
        for(int i = 1; i < height.length; i ++) {
            int currHeight = height[i];
            int currBloom = bloom[i];
            int currWilt = wilt[i];

            int offset = 0; // by default, type i is to be put to 1st row
            for(int j = 0; j < i; j ++) {
                if(currWilt >= optimalBloom[j] && currWilt <= optimalWilt[j] ||
                        currBloom >= optimalBloom[j] && currBloom <= optimalWilt[j]) {  // life period overlap
                    if(currHeight < optimal[j]) {  // life overlap, and type i is shorter than type j
                        offset = j;
                        break;
                    } else {
                        offset = j + 1; // type i overlap with type j, and i is taller than j. Put i after j
                    }
                } else {  // not overlap with current
                    if(currHeight < optimal[j]) {
                        offset = j + 1; // type i not overlap with j, i is shorter than j, put i after j
                    }
                }
            }

            for(int k = i - 1; k >= offset; k -- ) {
                optimal[k+1] = optimal[k];
                optimalBloom[k+1] = optimalBloom[k];
                optimalWilt[k+1] = optimalWilt[k];
            }

            optimal[offset] = currHeight;
            optimalBloom[offset] = currBloom;
            optimalWilt[offset] = currWilt;

            if(i == 1)
                System.out.println("ok");
            if(i == 2)
                System.out.println("ok");
            if(i == 3)
                System.out.println("ok");
        }
        return optimal;
    }
}
