package com.interview.lectures;

public class Solution {
	  public static int solution ( int[] A ) {
	      int maxProfit = 0;
	      int minID = 0;
	      int maxID = 0;
	      for(int i = 0; i < A.length; i++){
	          if (A[i] < A[minID]){
	              maxProfit = A[maxID] - A[minID];
	              minID = i;
	              maxID = i;
	          }
	          if (A[i] > A[maxID]){
	              maxID = i;
	          }
	      }
	      if (A[maxID] - A[minID] > maxProfit){
	          return A[maxID] - A[minID];
	      } else {
	          return maxProfit;
	      }
	  }
	  public static void main(String[] args){
		  int[] A = {23171, 21011, 21123, 21366, 21013, 21367, 20101};
		  System.out.println(Solution.solution(A));
	  }
	}

