package me.icemoon.hot100.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yulong
 * @create 2025/7/18
 * @description
 */
public class _0118_pascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> c = new ArrayList<>(numRows);
        c.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1); // 每行的第一个元素为1
            List<Integer> prevRow = c.get(i - 1);
            for (int j = 1; j < i; j++) {
                // 当前行的元素是上一行相邻两个元素之和
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1); // 每行的最后一个元素为1
            c.add(row);
        }
        return c;
    }
}
