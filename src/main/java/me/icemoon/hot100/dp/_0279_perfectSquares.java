package me.icemoon.hot100.dp;

/**
 * @author Yulong
 * @create 2025/7/18
 * @description
 */
public class _0279_perfectSquares {
    public int numSquares(int n) {
        // dp[i] 表示和为 i 的完全平方数的最少数量
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
