package com.interview.leetcode.dp;

/**
 * Created_By: stefanie
 * Date: 14-11-25
 * Time: 下午8:37
 */
public class TwoSequenceDP {
    /**
     * Given two strings, find the longest comment subsequence (LCS).
     * Your code should return the length of LCS.
     */
    static class LongestCommonSubsequence{
//        state[i][j] = the length of LCS with i chars in S1 and j chars in S2
//        initialize:
//                  state[0][j] = 0   for j = 0 to S2.length().
//                  state[i][0] = 0   for i = 0 to S1.length();
//        function:
//                  state[i][j] = state[i-1][j-1] + 1   if S1[i] == S2[j]
//                  state[i][j] = max{state[i-1][j], state[i][j-1]}  if S1[i] != S2[j]
//        Result: state[S1.length()][S2.length()]
        public int longest(String A, String B) {
            if(A == null || B == null) return 0;
            int[][] len = new int[A.length() + 1][B.length() + 1];
            len[0][0] = 0;
            for(int i = 1; i <= A.length(); i++) len[i][0] = 0;
            for(int j = 1; j <= B.length(); j++) len[0][j] = 0;

            for(int i = 1; i <= A.length(); i++){
                for(int j = 1; j <= B.length(); j++){
                    if(A.charAt(i - 1) == B.charAt(j - 1)){
                        len[i][j] = len[i - 1][j - 1] + 1;
                    } else {
                        len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
                    }
                }
            }
            return len[A.length()][B.length()];
        }
    }

    /**
     * Given two strings, find the longest common substring.
     * Return the length of it.
     */
    static class LongestCommonSubstring{
        public int longestCommonSubstring(String A, String B) {
            if(A == null || B == null) return 0;
            int[][] len = new int[A.length() + 1][B.length() + 1];
            len[0][0] = 0;
            for(int i = 1; i <= A.length(); i++) len[i][0] = 0;
            for(int j = 1; j <= B.length(); j++) len[0][j] = 0;
            int max = 0;
            for(int i = 1; i <= A.length(); i++){
                for(int j = 1; j <= B.length(); j++){
                    if(A.charAt(i - 1) == B.charAt(j - 1)){
                        len[i][j] = len[i - 1][j - 1] + 1;
                        max = Math.max(max, len[i][j]);
                    } else {
                        len[i][j] = 0; //different from LCS
                    }
                }
            }
            return max;  //not len[A.length()][B.length()]
        }
    }

    /**
     * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.
     * You have the following 3 operations permitted on a word:
     *  a) Insert a character
     *  b) Delete a character
     *  c) Replace a character
     */
   static class EditDistance {
//    State: dis[i][j] is the edit distance of a.substring(0,i) and b.substring(0,j);
//    Transfer: dis[i][j] == min of following
//                  dis[i - 1][j - 1]     if(a.charAt(i-1) == b.charAt(j-1))  //equals
//                  dis[i - 1][j - 1] + 1 if(a.charAt(i-1) != b.charAt(j-1))  //modify
//                  dis[i - 1][j] or dis[i][j - 1]
//    Init: dis[0][0] = 0
//          dis[0][i] = i and dis[i][0] = i
//    Answer: dis[a.length()][b.length()]
        public static int minDistance(String a, String b) {
            int n = a.length();
            int m = b.length();
            int[][] dis = new int[n + 1][m + 1];
            for(int i = 0; i <= n; i++) dis[i][0] = i;
            for(int j = 0; j <= m; j++) dis[0][j] = j;

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    dis[i][j] = (a.charAt(i-1) == b.charAt(j-1))? dis[i-1][j-1] : dis[i-1][j-1] + 1;
                    int smaller = Math.min(dis[i-1][j], dis[i][j-1]) + 1;
                    dis[i][j] = Math.min(dis[i][j], smaller);
                }
            }
            return dis[n][m];
        }
    }

    /**
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
     * For example,
     *  Given:
     *      s1 = "aabcc", s2 = "dbbca",
     *  When s3 = "aadbbcbcac", return true.
     *  When s3 = "aadbbbaccc", return false.
     *
     */
    static class InterleavingString {
        //State: match[i][j]: i chars from s1, j chars from s2 is interleaving of i + j chars from s3
        //Transfer:
        //  match[i][j] == true when
        //      s1.charAt(i-1) == s3.charAt(i + j - 1) && match[i-1][j]
        //   or s2.charAt(j-1) == s3.charAt(i + j - 1) && match[i][j-1]
        //Init: match[i][0] = true when s1.charAt(i - 1) == s3.charAt(i - 1)
        //      match[0][i] = true when s2.charAt(i - 1) == s3.charAt(i - 1)
        //Result: match[n][m]
        public static boolean isInterleave(String s1, String s2, String s3) {
            if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) return false;
            int n = s1.length();
            int m = s2.length();
            boolean[][] match = new boolean[n + 1][m + 1];
            match[0][0] = true;
            for(int i = 1; i <= n; i++) match[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1);
            for(int j = 1; j <= m; j++) match[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1);

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    match[i][j] = (match[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                            ||(match[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
            return match[n][m];
        }
    }

    /**
     * Given a string S and a string T, count the number of distinct subsequences of T in S.
     * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters
     * without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
     * Here is an example: S = "rabbbit", T = "rabbit" Return 3.
     *
     */
    static class DistinctSubsequence {
        //State: num[i][j]: the subsequence num of S.substring(0, i) and T.substring(0, j);
        //Transfer:
        //  1. if S.charAt(i - 1) != T.charAt(j - 1)    num[i][j] = num[i - 1][j]
        //  2. if S.charAt(i - 1) == T.charAt(j - 1)    num[i][j] = num[i - 1][j] + num[i - 1][j - 1]
        //Init: num[0][*] = 1 and num[0][*] = 0
        //Ans: num[n][m]
        public int numDistinct(String S, String T) {
            int n = S.length();
            int m = T.length();
            int[][] num = new int[n + 1][m + 1];
            for(int i = 0; i <= n; i++) num[i][0] = 1;
            for(int j = 1; j <= m; j++) num[0][j] = 0;
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    num[i][j] = num[i-1][j];
                    if(S.charAt(i - 1) == T.charAt(j - 1))  num[i][j] += num[i-1][j-1];
                }
            }
            return num[n][m];
        }
    }

    /**
     * Given a string s, find out the min cut needed to partition it to palindrome
     */
    static class PalindromePartition {

//        minCut[i]: the min cuts with i chars in s
//        initialization: minCut[0] = 0; minCut[1] = 0;
//        function: minCut[i] = min{minCut[j] + 1, s[0...j] can be partitioned into palindromes and s[j..i] is a palindrome}
//        result: minCut[s.length()]
        public int minCut(String s){
            if(s == null || s.length() == 1) return 0;
            boolean[][] isPalindrome = calculate(s);
            int[] minCut = new int[s.length()];
            minCut[0] = 0;
            for(int i = 1; i < s.length(); i++){
                minCut[i] = minCut[i-1] + 1;
                if(isPalindrome[0][i]) {
                    minCut[i] = 0;
                    continue;
                }
                for(int j = 1; j < i; j++){
                    if(isPalindrome[j][i]) minCut[i] = Math.min(minCut[i], minCut[j - 1] + 1);
                }
            }
            return minCut[s.length() - 1];
        }

//        palindrome[i][j]:  if substring(i, j + 1) is palindrome
//        initialize:   palindrome[i][i] = true  0<= i < S.length
//        function:   palindrome[i][i+len] = (len == 1? true : palindrome[i+1][i+len-1]) && s.charAt(i) == s.charAt(i + len);
//        for loop on len, and i
        public boolean[][] calculate(String s){ //substring(i, j + 1) is palindrome
            boolean[][] palindrome = new boolean[s.length()][s.length()];
            for(int i = 0; i < s.length(); i++) palindrome[i][i] = true;
            for(int len = 1; len < s.length(); len++){
                for(int i = 0; i+len < s.length(); i++){
                    palindrome[i][i+len] = (len == 1? true : palindrome[i+1][i+len-1]) && s.charAt(i) == s.charAt(i + len);
                }
            }
            return palindrome;
        }
    }

    /**
     * Implement regular expression matching with support for '.' and '*'.
     *      '.' Matches any single character.
     *      '*' Matches zero or more of the preceding element.
     */
    static class RegularExpressionMatching{
        //    State: match[i][j]  s.substring(0, i) matched p.substring(0, j);
//    Transfer: match[i][j] = true if
//                  match[i-1][j-1] && match(i, j);
//                  if j is '*' && match[i][j-2]   //a* doesn't match any char in s   //0
//                  if j is '*' && match(i, j - 1) && (match[i-1][j] || match[i][j-1])
//                              match[i-1][j]: "a*" match 'a'   //1
//                              match[i][j-1]: "a*" match 'aa~' //>1
//    Init: match[0][0] == true
//          match[0][j] == true when if j is '*' && match[0][j-2]
//    Result: match[m][n]
        public static boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] match = new boolean[m+1][n+1];
            match[0][0] = true;
            for(int j = 1; j <= n; j++){
                match[0][j] = (p.charAt(j - 1) == '*') && (j - 2 >= 0) && match[0][j-2];
            }

            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    match[i][j] = (match[i-1][j-1] && match(s, p, i, j))
                            || (p.charAt(j - 1) == '*' && match(s, p, i, j - 1) && (match[i-1][j] || match[i][j-1]))
                            || (p.charAt(j - 1) == '*' && j - 2 >= 0 && match[i][j-2]);
                }
            }
            return match[m][n];
        }

        public static boolean match(String s, String p, int i, int j){
            return (p.charAt(j - 1) == '.') || (p.charAt(j - 1) == s.charAt(i - 1));
        }
    }

    /**
     * Given n distinct positive integers, integer k (k <= n) and a number target.
     * Find k numbers where sum is target. Calculate how many solutions there are?
     */
    static class KSum {
        public int find(int A[],int k,int target) {
            return 0;
        }
    }

}
