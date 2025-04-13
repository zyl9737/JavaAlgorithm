package me.icemoon.hot100.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yulong
 * @create 2025/4/13
 * @description 560.和为K的子数组
 * 时间复杂度: O(n)
 * 空间复杂度：O(n) 指定了初始容量
 */
public class _0560_SubarraySumEqualsK {
    // 两次遍历
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int s = 0;
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>(nums.length + 1);
        cnt.put(0, 1);
        for (int x : nums) {
            s += x;
            ans += cnt.getOrDefault(s - k, 0);
            cnt.merge(s, 1, Integer::sum); // cnt[s]++
        }
        return ans;
    }

    // 一次遍历做法
    public int subarraySum2(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }
        Map<Integer, Integer> cnt = new HashMap<>(n + 1);
        for (int sj : s) {
            ans += cnt.getOrDefault(sj - k, 0);
            cnt.merge(sj, 1, Integer::sum);
        }
        return ans;
    }
}
