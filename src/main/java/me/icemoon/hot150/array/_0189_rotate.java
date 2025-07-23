package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/23
 * @description
 */
public class _0189_rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // 处理k大于n的情况
        reverse(nums, 0, n - 1); // 先反转整个数组
        reverse(nums, 0, k - 1); // 再反转前k个元素
        reverse(nums, k, n - 1); // 最后反转剩余的元素
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
