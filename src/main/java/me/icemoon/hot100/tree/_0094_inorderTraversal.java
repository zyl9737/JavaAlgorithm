package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Yulong
 * @create 2025/6/5
 * @description 二叉树的中序遍历 https://leetcode.cn/problems/binary-tree-inorder-traversal
 */
public class _0094_inorderTraversal {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }

    public List<Integer> inorderTraversal_iteration(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            // 此时 cur 为 null，说明左子树已遍历到底
            cur = st.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }
}
