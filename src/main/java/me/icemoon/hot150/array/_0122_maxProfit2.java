package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/24
 * @description
 */
public class _0122_maxProfit2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0; // 如果价格数组长度小于2，无法进行交易
        int ans = 0;
        for (int i = 1; i < n; i++) {
            // 如果今天的价格大于昨天的价格，则可以进行交易
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1]; // 累加利润
            }
        }
        return ans; // 返回总利润
    }
}
