package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/24
 * @description
 */
public class _0121_maxProfit {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = prices[0];
        for (int p : prices) {
            ans = Math.max(ans, p - minPrice);
            minPrice = Math.min(p, minPrice);
        }
        return ans;
    }
}
