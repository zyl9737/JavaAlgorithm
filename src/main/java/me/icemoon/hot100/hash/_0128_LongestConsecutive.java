package me.icemoon.hot100.hash;
import java.util.HashSet;
import java.util.Set;
/**
 * @description 128.最长连续序列
 */



public class _0128_LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int ans = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int y = x + 1;
                while (set.contains(y)) {
                    y++;
                }
                ans = Math.max(ans, y - x);
            }
        }
        return ans;
    }

}
