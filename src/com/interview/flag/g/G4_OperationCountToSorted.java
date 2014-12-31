package com.interview.flag.g;

/**
 * Created_By: stefanie
 * Date: 14-12-31
 * Time: 下午7:27
 */
public class G4_OperationCountToSorted {
    private int longestNonDecreasingSequence(int[] num){
        int maxLen = 0;
        int[] length = new int[num.length];
        for(int i = 0; i < num.length; i++){
            length[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(num[i] >= num[j]) length[i] = Math.max(length[i], length[j] + 1);
            }
            maxLen = Math.max(maxLen, length[i]);
        }
        return maxLen;
    }

    public int count(int[] num){
        int maxNonDecreasingSequence = longestNonDecreasingSequence(num);
        return num.length - maxNonDecreasingSequence;
    }

    public static void main(String[] args){
        G4_OperationCountToSorted counter = new G4_OperationCountToSorted();
        int[] num = new int[]{4,1,3,5,2};
        System.out.println(counter.count(num)); //2
    }
}
