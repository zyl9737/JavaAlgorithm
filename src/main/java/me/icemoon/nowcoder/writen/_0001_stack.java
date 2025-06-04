package me.icemoon.nowcoder.writen;

import java.util.Scanner;

/**
 * @author Yulong
 * @create 2025/5/30
 * @description
 */
public class _0001_stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        int[] stk = new int[n];
        int top = -1; // 栈顶指针
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String [] parts = line.split(" ");
            String op = parts[0];

            switch (op) {
                case "push":
                    int num = Integer.parseInt(parts[1]);
                    stk[++top] = num; // 入栈
                    break;
                case "pop":
                    if (top == -1) {
                        System.out.println("error");
                    } else {
                        System.out.println(stk[top--]); // 出栈
                    }
                    break;
                case "top":
                    if (top == -1) {
                        System.out.println("error");
                    } else {
                        System.out.println(stk[top]); // 获取栈顶元素
                    }
                    break;
            }
        }

    }
}
