package me.icemoon.hot100.dp;

/**
 * @author Yulong
 * @create 2025/7/22
 * @description  最长公共子序列
 * 相等：dp[i][j] = dp[i - 1][j - 1] + 1
 * 不相等：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
 */
public class _1143_longestCommonSubseq {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <=m; i++) {
            int prev = 0; // 存dp[i - 1][j - 1]
            for (int j = 1; j <= n; j++){
                int tmp = dp[j]; // 存dp[i - 1][j]
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1; // 如果字符相同，长度加1
                } else {
                    dp[j] = Math.max(tmp, dp[j - 1]); // 如果字符不同，取左边或上边的最大值
                }
                prev = tmp;
            }
        }
        return dp[n]; // 返回最长公共子序列的长度
    }
}
