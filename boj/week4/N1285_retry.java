package boj.week4;

import java.util.Scanner;

// 동전 뒤집기
public class N1285_retry {
    static char[][] map;
    static int N;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }

        for (int row = 0; row < 1 << N; row++) {
            res = Math.min(getTailSum(row), res);
        }
        System.out.print(res);
    }

    static int getTailSum(int row) {
        int sum = 0;
        for (int j = 0; j < N; j++) {
            int hCnt = 0;
            int tCnt = 0;
            for (int i = 0; i < N; i++) {
                // 뒤집
                if(((row >> i) & 1) > 0){
                    if(map[i][j] == 'H') tCnt++;
                    else hCnt++;
                }else{
                    if(map[i][j] == 'H') hCnt++;
                    else tCnt++;
                }
            }
            sum += Math.min(hCnt, tCnt);
        }
        return sum;
    }
}
