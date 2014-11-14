package com.interview.leetcode.arrays.searching;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 下午4:33
 */
public class SearchingSortedArrayWithDuplication {

    public static int findFirstL(int[] array, int target){
        int offset = searchLower(array, target);
        return array[offset] == target ? offset : -1;
    }

    /*
           If target is in A, return the first occurance of target in A.
                     For {0, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8} and target = 5, the returned offset is 5
           If target is NOT in A, return the first number that’s bigger than target (also the right position to insert target value).
                     For {0, 1, 2, 3, 4, 6, 7, 8} and target = 5, the returned offset is 5.
      */
    private static int searchLower(int[] array, int target) {
        int lower = 0;
        int higher = array.length - 1;
        while(lower < higher) {
            int mid = (lower + higher) / 2;
            if (array[mid] < target) lower = mid + 1;
            else higher = mid;
        }
        return lower;
    }

    public static int findLastL(int[] array, int target){
        int offset = searchHigher(array, target);
        if(offset == 0) return -1;
        else return array[offset - 1] == target ? offset - 1 : -1;
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

    public static int findFirstR(int[] array, int target) {
        return findFirstR(array, target, 0, array.length - 1);
    }

    private static int findFirstR(int[] array, int target, int low, int high){
        if(low > high) return -1;
        int mid = (low + high)/2;
        if(target == array[mid]){          //check if could find same element in low ~ mid-1
            int before = findFirstR(array, target, low, mid - 1);
            return before != -1? before : mid;
        } else if(target < array[mid]) return findFirstR(array, target, low, mid - 1);
        else return findFirstR(array, target, mid + 1, high);
    }


    public static int findLastR(int[] array, int target){
        return findLastR(array, target, 0, array.length - 1);
    }

    private static int findLastR(int[] array, int target, int low, int high){
        if(low > high) return -1;
        int mid = (low + high)/2;
        if(target == array[mid]){          //check if could find same element in mid+1 ~ high
            int after = findLastR(array, target, mid + 1, high);
            return after != -1? after : mid;
        } else if(target < array[mid]) return findLastR(array, target, low, mid - 1);
        else return findLastR(array, target, mid + 1, high);
    }
}
