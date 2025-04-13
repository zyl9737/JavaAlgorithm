package me.icemoon.AcWing.dfs;
import java.util.Scanner;
/**
 * @author Yulong
 * @create 2025/4/13
 * @description AcWing 843. n-皇后问题
 */
public class Dfs02 {
    private static int n, N = 20;
    private static char[][] g = new char[N][N];
    private static boolean [] cal = new boolean[N];
    private static boolean[] dg = new boolean[N];
    private static boolean[] udg = new boolean[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 0 ; i < n ;i ++ )
            for(int j = 0 ;j < n ;j ++ )
                g[i][j] = '.';

        dfs(0);
    }
    public static void dfs(int u){
        if(u == n){
            for(int i = 0 ; i < n ; i ++ ){
                for(int j = 0;j < n ;j ++ ){
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < n; i ++ ){
            if(!cal[i] && !dg[i + u] & !udg[i - u + n]){
                g[u][i] = 'Q';
                cal[i] = dg[i + u] = udg[i - u + n] = true;
                dfs(u + 1);
                cal[i] = dg[i + u] = udg[i - u + n] = false;
                g[u][i] = '.';
            }
        }
    }
}
