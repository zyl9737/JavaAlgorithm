package me.icemoon.hot100.matrix;

/**
 * @author Yulong
 * @create 2025/5/8
 * @description 搜索二维矩阵Ⅱ
 */
public class _0240_SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0;
        int y = n - 1;
        while (x < m - 1 && y > 0) {
            int t = matrix[x][y];
            if (t == target) return true;
            if (t < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}
