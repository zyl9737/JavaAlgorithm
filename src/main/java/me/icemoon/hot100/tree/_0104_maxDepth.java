package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

/**
 * @author Yulong
 * @create 2025/6/5
 * @description 二叉树的最大深度 https://leetcode.cn/problems/maximum-depth-of-binary-tree
 */
public class _0104_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l_depth = maxDepth(root.left);
        int r_depth = maxDepth(root.right);
        return Math.max(l_depth, r_depth) + 1;
    }

    private int ans;

    public int maxDepth2(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        depth++;
        ans = Math.max(ans, depth);
        dfs(node.left, depth);
        dfs(node.right, depth);
    }
}
