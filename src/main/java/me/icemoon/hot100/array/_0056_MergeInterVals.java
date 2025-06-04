package me.icemoon.hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Yulong
 * @create 2025/4/14
 * @description 合并区间
 */
public class _0056_MergeInterVals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] p : intervals) {
            int m = res.size();
            if (m > 0 && res.get(m - 1)[1] >= p[0]) {
                res.get(m - 1)[1] = Math.max(res.get(m - 1)[1], p[1]);
            } else {
                res.add(p);
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}
