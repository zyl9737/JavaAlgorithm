package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

/**
 * @author Yulong
 * @create 2025/6/5
 * @description 二叉树的最大深度 https://leetcode.cn/problems/maximum-depth-of-binary-tree
 */
public class _0104_maxDepth {
    public int maxDepth(TreeNode root) {
       return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
