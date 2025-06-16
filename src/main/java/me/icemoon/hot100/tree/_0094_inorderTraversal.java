package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

import java.util.*;

/**
 * @author Yulong
 * @create 2025/6/5
 * @description 二叉树的中序遍历 https://leetcode.cn/problems/binary-tree-inorder-traversal
 */
public class _0094_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}
