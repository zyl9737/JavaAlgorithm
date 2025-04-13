package me.icemoon.hot100.two_point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0015_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (x + nums[i + 1] + nums[i + 2] > 0) break;
            if (x + nums[n - 2] + nums[n - 1] < 0) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s < 0) {
                    j++;
                } else if (s > 0) {
                    k--;
                } else {
                    res.add(List.of(x, nums[j], nums[k]));
                    for (j++; j < k && nums[j] == nums[j - 1]; j++);
                    for (k--; k > j && nums[k] == nums[k + 1]; k--);
                }
            }
        }
        return res;
    }

}
