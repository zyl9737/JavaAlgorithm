package me.icemoon.hot100.array;

/**
 * @description 41.缺失的第一个正数
 *
 */
class _0041_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int hashSize = n + 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] >= hashSize) {
                nums[i] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] % hashSize != 0) {
                int pos = (nums[i] % hashSize) - 1;
                // 出现过的位置让它大于hashSize
                nums[pos] = (nums[pos] % hashSize) + hashSize;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] < hashSize) {
                return i + 1;
            }
        }
        return hashSize;
    }

}
