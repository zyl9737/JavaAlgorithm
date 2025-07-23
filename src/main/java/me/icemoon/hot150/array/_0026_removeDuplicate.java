package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/23
 * @description 给定一个有序数组，删除重复元素，使每个元素只出现一次，并返回新数组的长度。
 */
public class _0026_removeDuplicate {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // 如果数组为空，返回0

        int k = 1; // k是新数组的长度，从1开始，因为第一个元素总是保留
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) { // 如果当前元素不等于上一个保留的元素
                nums[k++] = nums[i]; // 将当前元素放到新位置
            }
        }
        return k; // 返回新数组的长度
    }
}
