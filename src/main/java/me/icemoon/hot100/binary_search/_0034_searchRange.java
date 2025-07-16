package me.icemoon.hot100.binary_search;

/**
 * @author Yulong
 * @create 2025/7/11
 * @description
 */
public class _0034_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        int r = search(nums, target + 1);
        return l == r ? new int[] {-1, -1} : new int[] {l, r - 1};
    }

    private int search(int[] nums, int x) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            System.out.println("Searching for " + x + " in range [" + left + ", " + right + ")");
            if (nums[mid] <  x) {
                left = mid + 1;
            } else {
                right = mid;
            }
            System.out.println("left: " + left + ", right: " + right + ", mid: " + mid);
        }
        return left;
    }

    public static void main(String[] args) {
        _0034_searchRange searchRange = new _0034_searchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange.searchRange(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
