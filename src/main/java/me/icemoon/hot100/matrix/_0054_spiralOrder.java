package me.icemoon.hot100.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yulong
 * @create 2025/4/15
 * @description 54.螺旋矩阵
 */
public class _0054_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        while (true) {
            // 从左往右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) break;
            // 从上往下
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (right < left) break;
            // 从右往左
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (bottom < top) break;;
            // 从下往上
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;
        }
        return res;
    }
}
