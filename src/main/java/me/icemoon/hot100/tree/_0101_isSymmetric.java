package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

/**
 * @author Yulong
 * @create 2025/6/16
 * @description 对称二叉树
 */
public class _0101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSameTree(root.left, root.right);
    }
    public boolean isSameTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSameTree(left.left, right.right) && isSameTree(left.right, right.left);
    }
}
