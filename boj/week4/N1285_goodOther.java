package boj.week4;

import java.util.Scanner;

public class N1285_goodOther {
    static int N;
    static int res = 400;
    static int[] coins;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            String next = sc.next();
            for (int j = 0; j < N; j++) {
                if(next.charAt(j) == 'T'){
                    coins[i] |= (1 << N - 1 - j);
                }
            }
        }
        solve(0);
        System.out.print(res);
    }

    static void solve(int row) {
        if (row == N - 1) {
            int sum = 0;
            for (int i = 1; i < 1 << N; i *= 2) {
                int tSum = 0;
                for (int j = 0; j < N; j++) {
                    if((i & coins[j]) > 0) tSum++;
                }
                sum += Math.min(tSum, N - tSum);
            }
            res = Math.min(res, sum);
            return;
        }
        solve(row+1);
        coins[row+1] = ~coins[row+1];
        solve(row+1);
    }
}
