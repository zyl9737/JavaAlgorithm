package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/8/11
 * @description
 */
public class _0013_romanToInt {
    public int romanToInt(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I' -> {
                    if (i < n - 1) {
                        char next = s.charAt(i + 1);
                        if (next == 'V') {
                            res += 4;
                            i++;
                        } else if (next == 'X') {
                            res += 9;
                            i++;
                        } else {
                            res += 1;
                        }
                    } else {
                        res += 1;
                    }
                }
                case 'V' -> res += 5;
                case 'X' -> {
                    if (i < n - 1) {
                        char next = s.charAt(i + 1);
                        if (next == 'L') {
                            res += 40;
                            i++;
                        } else if (next == 'C') {
                            res += 90;
                            i++;
                        } else {
                            res += 10;
                        }
                    } else {
                        res += 10;
                    }
                }
                case 'L' -> res += 50;
                case 'C' -> {
                    if (i < n - 1) {
                        char next = s.charAt(i + 1);
                        if (next == 'D') {
                            res += 400;
                            i++;
                        } else if (next == 'M') {
                            res += 900;
                            i++;
                        } else {
                            res += 100;
                        }
                    } else {
                        res += 100;
                    }
                }
                case 'D' -> res += 500;
                case 'M' -> res += 1000;
            }
        }
        return res;
    }
}
