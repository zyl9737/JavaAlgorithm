package me.icemoon.hot100.dp;

/**
 * @author Yulong
 * @create 2025/7/21
 * @description
 */
public class _0152_maxProduct {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE; // 注意答案可能是负数
        int fMax = 1;
        int fMin = 1;
        for (int x : nums) {
            int mx = fMax;
            fMax = Math.max(Math.max(fMax * x, fMin * x), x);
            fMin = Math.min(Math.min(mx * x, fMin * x), x);
            ans = Math.max(ans, fMax);
        }
        return ans;
    }

}
