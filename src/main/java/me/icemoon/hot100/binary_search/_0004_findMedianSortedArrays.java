package me.icemoon.hot100.binary_search;

/**
 * @author Yulong
 * @create 2025/7/14
 * @description
 */
public class _0004_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            int left = find(nums1, 0, nums2, 0, total / 2);
            int rigth = find(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + rigth) / 2.0;
        } else {
            return find(nums1, 0, nums2, 0, total / 2 + 1);
        }
    }

    private int find(int[] nums1, int i, int[] nums2, int j, int k) {
        if (nums1.length - i > nums2.length - j) {
            return find(nums2, j, nums1, i, k);
        }
        if (i == nums1.length) {
            return nums2[j + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int mid1 = Math.min(i + k / 2, nums1.length) - 1;
        int mid2 = j + k / 2 - 1;
        if (nums1[mid1] > nums2[mid2]) {
            return find(nums1, i, nums2, mid2 + 1, k - (mid2 - j + 1));
        } else {
            return find(nums1, mid1 + 1, nums2, j, k - (mid1 - i + 1));
        }
    }
}
