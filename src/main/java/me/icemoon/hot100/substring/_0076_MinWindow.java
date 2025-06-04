package me.icemoon.hot100.substring;

/**
 * @description 最小覆盖子串
 * 时间复杂度：O(128m + n) left指针每移动一次128
 */
public class _0076_MinWindow {

    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        int[] target = count(t);
        int l = 0;
        int ansL = -1;
        int ansR = s.length();
        for (int r = 0; r < s.length(); r++) {
            cnt[s.charAt(r)] += 1;
            while (has(cnt, target)) {
                if (r - l < ansR - ansL) {
                    ansL = l;
                    ansR = r;
                }
                cnt[s.charAt(l)] -= 1;
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }

    int[] count(String s) {
        int[] cnt = new int[128];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cnt[c]++;
        }
        return cnt;
    }

    boolean has(int[] s, int[] t) {
        for (int i = 0; i < 128; i++) {
            if (s[i] < t[i]) {
                return false;
            }
        }
        return true;
    }

}
