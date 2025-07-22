package me.icemoon.hot100.dp;

/**
 * @author Yulong
 * @create 2025/7/21
 * @description
 */
public class _0062_uniquePaths {
    public int uniquePaths(int m, int n) {
        // dp[i][j] 表示到达 (i, j) 的路径数量
        int[][] dp = new int[m][n];

        // 初始化第一行和第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1; // 第一列只能从上方到达
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1; // 第一行只能从左方到达
        }

        // 填充 dp 数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // 从上方或左方到达当前格子
            }
        }

        return dp[m - 1][n - 1]; // 返回到达右下角的路径数量
    }
}
