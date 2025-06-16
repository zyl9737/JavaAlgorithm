package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Yulong
 * @create 2025/6/5
 * @description 翻转二叉树
 * 优先选择自根向叶（前序：逻辑直白，符合“先操作当前节点再处理子树”的常规递归思维，调试更直观
 *
 * 理解自叶向根的价值：在需要先获取子问题结果的场景（如计算子树高度）更适用，体现分治思想
 */
public class _0226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode r = invertTree(root.right);
        TreeNode l = invertTree(root.left);
        root.left = r;
        root.right = l;
        return root;
    }
}
