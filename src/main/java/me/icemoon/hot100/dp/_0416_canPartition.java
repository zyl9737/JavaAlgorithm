package me.icemoon.hot100.dp;

/**
 * @author Yulong
 * @create 2025/7/21
 * @description 给定一个整数数组 nums，判断是否可以将其划分为两个子集，使得两个子集的元素和相等。
 */
public class _0416_canPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果总和是奇数，无法划分成两个相等的子集
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        // dp[i] 表示是否可以找到一个子集，使得其元素和为 i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // 和为 0 的子集总是存在（空集）

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
