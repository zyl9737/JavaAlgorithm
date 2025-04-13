package me.icemoon.hot100.hash;

import java.util.HashMap;
/**
 * @author Yulong
 * @create 2025/4/13
 * @description 0001.两数之和
 */


public class _0001_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int choose = nums[i];
            int diff = target - choose;
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(choose, i);
        }
        return null;
    }

}
