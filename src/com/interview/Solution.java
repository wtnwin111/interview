package com.interview;

/**
 * Created_By: stefanie
 * Date: 14-12-17
 * Time: 上午8:30
 */
public class Solution {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while(i < v1.length && i < v2.length){
            Integer num1 = Integer.parseInt(v1[i]);
            Integer num2 = Integer.parseInt(v2[i]);
            if(num1 < num2) return -1;
            else if(num1 > num2) return 1;
            i++;
        }
        if(i == v1.length && i == v2.length) return 0;
        else if(i < v1.length) return 1;
        else return -1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int result = solution.compareVersion("1", "0");
        System.out.println(result);
//        List<Integer> list = new ArrayList(2);
//        list.set(1, 1);

//        System.out.println();
//        ConsoleWriter.printCollection(sols);
    }
}
