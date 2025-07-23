package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/23
 * @description 给定一个有序数组，删除重复元素，使每个元素最多出现两次，并返回新数组的长度。
 */
public class _0080_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length; // 如果数组长度小于等于2，直接返回长度

        int k = 2; // k是新数组的长度，至少保留两个元素
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) { // 如果当前元素不等于前两个保留的元素
                nums[k++] = nums[i]; // 将当前元素放到新位置
            }
        }
        return k; // 返回新数组的长度
    }
}
