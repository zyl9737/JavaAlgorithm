package me.icemoon.hot100.matrix;

/**
 * @author Yulong
 * @create 2025/5/8
 * @description 旋转矩阵
 */
public class _0048_Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[j][n - 1 - i] = tmp;
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
            }
        }
    }
}
