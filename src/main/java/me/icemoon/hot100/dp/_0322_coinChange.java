package me.icemoon.hot100.dp;

import java.util.Arrays;

/**
 * @author Yulong
 * @create 2025/7/18
 * @description 322. 零钱兑换
 */
public class _0322_coinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {  // 避免溢出
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
