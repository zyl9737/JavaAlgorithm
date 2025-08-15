package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/28
 * @description
 */
public class _0135_candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1; // 每个孩子至少分配一个糖果
        }

        // 从左到右遍历，确保右边的孩子比左边的孩子评分高时，糖果数更多
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }

        // 从右到左遍历，确保左边的孩子比右边的孩子评分高时，糖果数更多
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }

        // 计算总糖果数
        int totalCandies = 0;
        for (int candy : res) {
            totalCandies += candy;
        }

        return totalCandies;

    }
}
