package me.icemoon.hot100.dp;

/**
 * @author Yulong
 * @create 2025/7/22
 * @description
 */
public class _0072_minDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j] 表示 word1 的前 i 个字符和 word2 的前 j 个字符的最小编辑距离
        int[][] dp = new int[m + 1][n + 1];

        // 初始化边界条件
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // 删除所有字符
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // 插入所有字符
        }

        // 填充 DP 表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // 字符相同，不需要操作
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    // 删除、插入或替换操作
                }
            }
        }

        return dp[m][n]; // 返回最终结果
    }
}
