package boj.week4.hidden.level7;

import java.util.Scanner;

// 설탕 배달
public class N2839 {
    static int N;
    static boolean[][] cache = new boolean[2001][2001];
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        solve(0, 0);
        System.out.print(res == Integer.MAX_VALUE ? -1 : res);
    }

    static void solve(int x, int y) {
        if(3*x + 5*y == N){
            res = Math.min(res, x + y);
            return;
        }
        else if(3*x + 5*y > N) return;
        if (!cache[x][y + 1]) {
            cache[x][y + 1] = true;
            solve(x, y + 1);
        }
        if(!cache[x+1][y]){
            cache[x + 1][y] = true;
            solve(x + 1, y);
        }
    }
}
