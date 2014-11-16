package com.interview.leetcode.dp;

/**
 * Created_By: stefanie
 * Date: 14-11-16
 * Time: 下午10:40
 *
 * Implement regular expression matching with support for '.' and '*'.
 *      '.' Matches any single character.
 *      '*' Matches zero or more of the preceding element.
 * 
 * State: match[i][j] means s.substring(0,i) could match p.substring(0,j).
 * Init:  match[0][0] = true, match[*][0] = false, match[0][j] = match[0][j-2] if j-th char is "*"   //b match ba*  since * is zero or more of preceding element
 * Produce:
 *      case 1: match[i-1][j-1] is true, and ith character of s is equal to j th character of p. Or j th character of p is '.'
 *      case 2: match[i-1][j] is true, then my pattern now is '*' and preceding character is equal to incoming character of s   "aa" match "a*"
 *      case 3: match[i][j-1] is true, then my pattern now is '*' which can match an empty string  "a" match "a*"
 *      case 4: match[i][j-2] is true, and the pattern like (a*) matches an empty string   "" match "a*"
 */
public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        if (s == null || p == null) return false;

        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;

        for (int i = 1; i <= m; i++) match[i][0] = false;
        for (int j = 1; j <= n; j++) match[0][j] = (p.charAt(j - 1) == '*') && (j - 2 >= 0) && match[0][j - 2];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                match[i][j] = ((match[i - 1][j - 1]) && equals(s, p, i - 1, j - 1))
                        || ((p.charAt(j - 1) == '*') && equals(s, p, i - 1, j - 2) && (match[i - 1][j] || match[i][j - 1]))
                        || ((p.charAt(j - 1) == '*') && (j - 2 >= 0) && match[i][j - 2]);
            }
        }

        return match[m][n];
    }

    private static boolean equals(String s, String p, int si, int pi) {
        return (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.');
    }
}
