package com.interview.flag.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created_By: stefanie
 * Date: 15-1-28
 * Time: 下午10:46
 */
public class F13_SubsetSumK {
    public int[] subarray(int[] array, int K){
        HashMap<Integer, List<Integer>> sums = new HashMap();
        int sum = 0;
        for(int i = -1; i < array.length; i++){
            if(i >= 0) sum += array[i];
            if(sums.containsKey(sum)) sums.get(sum).add(i);
            else {
                List<Integer> indexes = new ArrayList();
                indexes.add(i);
                sums.put(sum, indexes);
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : sums.entrySet()){
            int target = entry.getKey() + K;
            int start = entry.getValue().get(0); //pick the smallest index;
            if(sums.containsKey(target)){
                List<Integer> pos = sums.get(target);
                if(pos.get(pos.size() - 1) > start) return new int[]{start + 1, pos.get(pos.size() - 1)};
            }

//            only one case need to be check.
//            target = entry.getKey() - K;
//            int end = entry.getValue().get(entry.getValue().size() - 1);
//            if(sums.containsKey(target)){
//                List<Integer> pos = sums.get(target);
//                if(pos.get(0) < end) return new int[]{pos.get(0) + 1, end};
//            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args){
        F13_SubsetSumK finder = new F13_SubsetSumK();
        int[] array = new int[]{1,5,3,5,2,1,4};
        int[] range = finder.subarray(array, 8);
        System.out.println(range[0] + ", " + range[1]); //1,2
        range = finder.subarray(array, 10);
        System.out.println(range[0] + ", " + range[1]); //2,4
        range = finder.subarray(array, 17);
        System.out.println(range[0] + ", " + range[1]); //0,5
        range = finder.subarray(array, 18);
        System.out.println(range[0] + ", " + range[1]); //-1,-1
    }
}
