package me.icemoon.hot100.trick;

/**
 * @author Yulong
 * @create 2025/7/23
 * @description 给定一个包含红色、白色和蓝色，按比例排序的数组，要求将它们按颜色排序。
 */
public class _0075_sortColors {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = nums.length - 1;
        // 使用三指针法，zero指向0的下一个位置，one指向当前处理的位置，two指向2的下一个位置
        while (one <= two) {
            if (nums[one] == 0) {
                swap(nums, zero++, one++);
            } else if (nums[one] == 1) {
                one++;
            } else {
                swap(nums, one, two--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
