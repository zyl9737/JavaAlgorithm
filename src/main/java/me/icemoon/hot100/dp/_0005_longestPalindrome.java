package me.icemoon.hot100.dp;

/**
 * @author Yulong
 * @create 2025/7/22
 * @description
 */
public class _0005_longestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0, right = 0;
        int maxL = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxL) {
                        maxL = j - i + 1;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
