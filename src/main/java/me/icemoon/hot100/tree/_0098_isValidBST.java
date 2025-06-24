package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yulong
 * @create 2025/6/19
 * @description 验证二叉搜索树
 */
public class _0098_isValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null && pre.val >= cur.val) return false;
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }

}
