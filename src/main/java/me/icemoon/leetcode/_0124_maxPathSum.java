package me.icemoon.leetcode;

import me.icemoon.tools.TreeNode;

/**
 * @author Yulong
 * @create 2025/6/16
 * @description 124.二叉树中的最大路径和
 */
public class _0124_maxPathSum {
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int lVal = dfs(node.left);
        int rVal = dfs(node.right);
        ans = Math.max(ans, lVal + rVal + node.val);
        return Math.max(Math.max(lVal, rVal) + node.val, 0);
    }
}
