package me.icemoon.hot100.dp;

/**
 * @author Yulong
 * @create 2025/7/17
 * @description
 */
public class _0070_climbStairs {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
