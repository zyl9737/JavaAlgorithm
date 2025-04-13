package me.icemoon.AcWing.dfs;
import java.util.*;
/**
 * @author Yulong
 * @create 2025/4/13
 * @description AcWing 842. 排列数字
 */
public class Dfs01 {
    static int N = 10, n;
    static int[] path = new int[N];
    static boolean[] st = new boolean[N];
    public static void main(String[] args){
        Scanner scan  = new Scanner(System.in);
        n = scan.nextInt();
        dfs(0);
    }
    public static void dfs(int u){
        if(u == n){
            for(int i = 0 ; i < n ; i ++ ){
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1 ; i <= n ; i ++ ){
            if(!st[i]){
                path[u] = i;
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
                //path[u] = 0;
            }
        }
        }
}

