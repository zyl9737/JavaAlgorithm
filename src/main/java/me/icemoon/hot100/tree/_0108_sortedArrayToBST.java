package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

/**
 * @author Yulong
 * @create 2025/6/16
 * @description
 */
public class _0108_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left == right) return null;
        int m = (left + right) >>> 1;
        return new TreeNode(nums[m], dfs(nums, left, m), dfs(nums, m + 1, right));
    }
}
