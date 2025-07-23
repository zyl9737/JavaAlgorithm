package me.icemoon.hot100.trick;

/**
 * @author Yulong
 * @create 2025/7/23
 * @description 寻找重复数，类似于链表的环检测问题，使用快慢指针法。
 */
public class _0287_findDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
