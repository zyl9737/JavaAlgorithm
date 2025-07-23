package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/23
 * @description
 */
public class _0027_removeElement {
    public int removeElement(int[] nums, int val) {
        int k = 0; // k是新数组的长度
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i]; // 将不等于val的元素放到前面
            }
        }
        return k; // 返回新数组的长度
    }
}
