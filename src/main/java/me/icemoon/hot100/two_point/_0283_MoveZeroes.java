package me.icemoon.hot100.two_point;

/**
 * @description 283.移动零
 */
public class _0283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (index < i) {
                nums[index] = nums[i];
            }
            index++;

        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
