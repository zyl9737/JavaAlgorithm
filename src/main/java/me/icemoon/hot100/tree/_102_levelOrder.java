package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

import java.util.*;

/**
 * @author Yulong
 * @create 2025/6/16
 * @description
 */
public class _102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> vals = new ArrayList<>(n);
            while (n-- > 0) {
                TreeNode node = q.poll();
                vals.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ans.add(vals);
        }
        return ans;
    }
}
