package me.icemoon.hot100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yulong
 * @create 2025/7/3
 * @description
 */
public class _0039_combinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, target, candidates, res, path);
        return res;
    }

    private void dfs(int i, int left, int[] candidates, List<List<Integer>> res, List<Integer> path) {
        if (left == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (i == candidates.length || left < candidates[i]) {
            return;
        }

        dfs(i + 1, left, candidates, res, path);

        path.add(candidates[i]);
        dfs(i, left - candidates[i], candidates, res, path);
        path.remove(path.size() - 1);

    }
}
