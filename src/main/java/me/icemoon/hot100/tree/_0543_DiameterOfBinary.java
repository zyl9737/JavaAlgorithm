package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

/**
 * @author Yulong
 * @create 2025/6/16
 * @description
 */
public class _0543_DiameterOfBinary {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode node) {
        if (node == null) return -1;
        int lLen = dfs(node.left) + 1;
        int rLen = dfs(node.right) + 1;
        ans = Math.max(ans, lLen + rLen);
        return Math.max(lLen, rLen);
    }
}
