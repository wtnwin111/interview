package com.interview.flag.a;

/**
 * Created_By: stefanie
 * Date: 14-12-4
 * Time: 下午5:28
 */
public class A1_LCSReplacement {
    public static int getPosition(int[] array){
        int max = 0;
        int maxIndex = -1;
        int replace = 0;
        int replaceIndex = -1;
        int nonReplace = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == 1){
                replace++;
                nonReplace++;
            } else {
                if(replaceIndex != -1 && replace > max){
                    max = replace;
                    maxIndex = replaceIndex;
                }
                replaceIndex = i;
                replace = nonReplace + 1;
                nonReplace = 0;
            }
        }
        if(replace > max) maxIndex = replaceIndex;
        return maxIndex;
    }

    public static void main(String[] args){
        int[] array = new int[]{1,1,1,0,1,0,1,1,1,0,1,1,1};
        System.out.println(A1_LCSReplacement.getPosition(array));
        array = new int[]{1,1,1,0,1,1,1,1,1,0,1,1,1};
        System.out.println(A1_LCSReplacement.getPosition(array));
    }
}
