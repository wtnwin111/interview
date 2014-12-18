package com.interview.books.leetcodeoj;

/**
 * Created_By: stefanie
 * Date: 14-12-18
 * Time: 上午9:57
 */
public class LOJ2_MedianOfTwoSortedArray {
    //Basic Idea: find the k-th elements in A+B. do binary search on A to find the first element not in topK.
    //1.if(A.length > B.length) return findKthElement(B, A, K);
    //2.K is started from 1, so findKthElement(A, B, median + 1);
    //3.int high = A.length;
    //4.if(bIdx >= B.length || A[mid] < B[bIdx]) low = mid + 1;
    //5.check index out of range when get prevA and prevB

    public double findMedianSortedArrays(int A[], int B[]) {
        int median = (A.length + B.length)/2;
        if((A.length + B.length) % 2 == 1) return findKthElement(A, B, median + 1);
        else return (findKthElement(A, B, median) + findKthElement(A, B, median + 1))/2.0;
    }

    public int findKthElement(int[] A, int[] B, int K){
        if(A.length > B.length) return findKthElement(B, A, K);
        //find the first element in A not in TopK
        int low = 0;
        int high = A.length;
        while(low < high){
            int mid = low + (high - low)/2;
            int bIdx = (K - 1) - mid;
            if(bIdx >= B.length || A[mid] < B[bIdx]) low = mid + 1;  //A[low]...A[mid] is all in TopK
            else high = mid;
        }
        int prevA = low - 1 >= 0? A[low - 1] : Integer.MIN_VALUE;
        int prevB = K - 1 - low >= 0? B[K - 1 - low] : Integer.MIN_VALUE;
        return Math.max(prevA, prevB);
    }
}
