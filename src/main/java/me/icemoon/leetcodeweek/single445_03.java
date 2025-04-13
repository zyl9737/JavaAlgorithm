package me.icemoon.leetcodeweek;

/**
 * @author Yulong
 * @create 2025/4/13
 * @description 3518.最小回文排列
 * 试填法
 */
public class single445_03 {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int m = n / 2;
        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        if (perm(m, cnt, k) < k) return "";
        char[] leftS = new char[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 26; j++) {
                if (cnt[j] == 0) continue;
                cnt[j]--;
                int p = perm(m - i - 1, cnt, k);
                if (p >= k) {
                    leftS[i] = (char) ('a' + j);
                    break;
                }
                k -= p; // k太大，要填更大的字母
                cnt[j]++;
            }
        }
        StringBuilder ans = new StringBuilder(n);
        ans.append(leftS);
        if (n % 2 > 0) {
            ans.append((s.charAt(n / 2)));
        }
        for (int i = m - 1; i >= 0; i--) {
            ans.append(leftS[i]);
        }
        return ans.toString();
    }

    // 计算长度为 sz 的字符串的排列个数
    private int perm(int sz, int[] cnt, int k) {
        long res = 1;
        for (int c : cnt) {
            if (c == 0) {
                continue;
            }
            res *= comb(sz, c, k); // 先从 sz 个里面选 c 个位置填当前字母
            if (res >= k) return k;
            sz -= c;
        }
        return (int) res;
    }
    // 计算组合数C(n, m)
    private int comb(int n, int m, int k) {
        m = Math.min(m, n - m);
        long res = 1;
        for (int i = 1; i <= m; i++) {
            res = res * (n + 1 - i) / i;
            if (res >= k) return k;
        }

        return (int) res;
    }
}
