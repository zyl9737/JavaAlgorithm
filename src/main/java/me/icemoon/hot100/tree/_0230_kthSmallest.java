package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

/**
 * @author Yulong
 * @create 2025/6/19
 * @description 230. 二叉搜索树中第 K 小的元素
 */
public class _0230_kthSmallest {
    private int ans;
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null || k == 0) return;
        dfs(node.left);
        if (--k == 0) ans = node.val;
        dfs(node.right);
    }
}
