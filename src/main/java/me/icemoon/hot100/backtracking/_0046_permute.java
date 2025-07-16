package me.icemoon.hot100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yulong
 * @create 2025/7/2
 * @description
 */
public class _0046_permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = Arrays.asList(new Integer[nums.length]);
        boolean[] used = new boolean[nums.length];
        dfs(0, nums, res, path, used);
        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] used) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (used[j]) continue;
            path.set(i, nums[j]);
            used[j] = true;
            dfs(i + 1, nums, res, path, used);
            used[j] = false;
        }
    }
}
