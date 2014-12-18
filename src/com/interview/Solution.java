package com.interview;

/**
 * Created_By: stefanie
 * Date: 14-12-17
 * Time: 上午8:30
 */
public class Solution {

    //Time: O(log(min(m, n)),
    public static int findKth(int[] a, int[] b, int K){
        int m = a.length;
        int n = b.length;
        if(m > n) return findKth(b, a, K);
        //search the first element not in TopK in a
        int low = 0, high = m;
        while(low < high){
            int mid = low + (high - low) / 2;
            int bIdx = K - 1 - mid;   //a[0]…a[mid] in TopK, b should have K - 1 - mid element
            if(bIdx >= n || a[mid] < b[bIdx]) low = mid + 1;   //if j is out of range or b[j] is larger, so a[0]…a[mid] in TopK, continue to search in a[mid + 1]..a[m]
            else high = mid;   //a[mid +1]…a[high] not in TopK, so searching in a[0]…a[mid]
        }
        //the K-th element is the larger one in a[low - 1] and b[K - 1 - low]
        int keyA = low - 1 >= 0? a[low - 1] : Integer.MIN_VALUE;
        int keyB = K - 1 - low >= 0? b[K - 1 - low] : Integer.MIN_VALUE;
        return Math.max(keyA, keyB);
    }

    public double findMedian(int A[], int B[]) {
        int median = (A.length + B.length) / 2 + 1;
        if ((A.length + B.length) % 2 == 1) return findKth(A, B, median);
        else return (findKth(A, B, median - 1) + findKth(A, B, median)) / 2.0;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        double median = solution.findMedian(new int[]{1}, new int[]{1});
        System.out.println(median);
    }
}
