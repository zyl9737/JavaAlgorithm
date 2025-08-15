package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/24
 * @description
 */
public class _0274_hIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0; // 如果没有引用，返回0

        // 创建一个计数数组，记录每个引用次数的论文数量
        int[] count = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }

        // 从后向前计算h-index
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i; // 找到满足条件的最大h-index
            }
        }
        return 0; // 如果没有满足条件的h-index，返回0
    }
}
