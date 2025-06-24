package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yulong
 * @create 2025/6/19
 * @description 199. 二叉树的右视图
 */
public class _0199_rightSideView {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (depth == res.size()) res.add(node.val);
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
}
