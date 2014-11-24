package com.interview.leetcode.arrays.searching;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 下午4:33
 */
public class SearchingSortedArrayWithDuplication {

    public static int findFirst(int[] array, int target){
        int offset = searchLower(array, target);
        if(offset == array.length || array[offset] != target) return -1;
        else return offset;
    }

    /*
           If target is in A, return the first occurance of target in A.
                     For {0, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8} and target = 5, the returned offset is 5
           If target is NOT in A, return the first number that’s bigger than target (also the right position to insert target value).
                     For {0, 1, 2, 3, 4, 6, 7, 8} and target = 5, the returned offset is 5.
      */
    private static int searchLower(int[] array, int target) {
        int lower = 0;
        int higher = array.length;
        while(lower < higher) {
            int mid = (lower + higher) / 2;
            if (array[mid] < target) lower = mid + 1;
            else higher = mid;
        }
        return lower;
    }

    public static int findLast(int[] array, int target){
        int offset = searchHigher(array, target);
        if(offset == 0 || array[offset - 1] != target) return -1;
        else return offset - 1;
    }

    /*
           It always return the first number that is bigger than target.
                     For {0, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8} and target = 5, the returned offset is 8
                     For {0, 1, 2, 3, 4, 6, 7, 8} and target = 5, the returned offset is 5.
      */
    public static int searchHigher(int[] array, int target){
        int lower = 0;
        int higher = array.length;
        while(lower < higher) {
            int mid = (lower + higher) / 2;
            if (array[mid] <= target) lower = mid + 1;
            else higher = mid;
        }
        return higher;
    }

    public static int[] findRange(int[] array, int target){
        int offset = searchLower(array, target);
        if(offset == array.length || array[offset] != target) return new int[] {-1, -1};
        int[] range = new int[]{offset, offset};
        offset = searchHigher(array, target);
        range[1] = offset - 1;
        return range;
    }
}
