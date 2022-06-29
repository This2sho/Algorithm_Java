package boj.week4.hidden.level10;

import java.util.Scanner;
// 체스판 다시 칠하기
public class N1018 {
    static boolean[][] map;
    static int res = 10000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                if(s.charAt(j) == 'W') map[i][j] = true;
                else map[i][j] = false;
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                solve(i, j);
            }
        }
        System.out.print(res);

    }

    static void solve(int n, int m) {
        int wCnt = 0, bCnt = 0;
        for (int i = n; i < n + 8; i++) {
            boolean w, b;
            if(i % 2 == 0) {
                w = true;
                b = false;
            }
            else{
                w = false;
                b = true;
            }
            for (int j = m; j < m + 8; j++) {
                if(map[i][j] != w) wCnt++;
                if(map[i][j] != b) bCnt++;
                w = !w;
                b = !b;
            }
        }
        res = Math.min(res, Math.min(wCnt, bCnt));
    }
}
