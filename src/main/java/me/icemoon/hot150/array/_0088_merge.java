package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/23
 * @description
 */
public class _0088_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后往前合并
        int i = m - 1; // nums1的最后一个元素索引
        int j = n - 1; // nums2的最后一个元素索引
        int k = m + n - 1; // 合并后的数组的最后一个位置索引

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // 如果nums2还有剩余元素，直接复制到nums1前面
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
