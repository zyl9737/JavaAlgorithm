package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/23
 * @description
 */
public class _0169_majorityElements {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num; // 选择新的候选元素
            }
            count += (num == candidate) ? 1 : -1; // 更新计数
        }

        return candidate; // 返回候选元素
    }
}
