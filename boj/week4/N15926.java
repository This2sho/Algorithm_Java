package boj.week4;

import java.util.Scanner;

public class N15926 {
    static int N;
    static int res = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String S = sc.next();
        solve(S, 0);
        r_solve(S, N-1);
        System.out.print(res);
    }

    static void solve(String s, int startIdx) {
        int openCnt = 0;
        int length = 0;
        for (int i = startIdx; i < N; i++) {
            char c = s.charAt(i);
            if(c == '(') openCnt++;
            else openCnt--;
            length++;

            if(openCnt == 0) res = Math.max(res, length);
            else if(openCnt < 0) {
                solve(s, i+1);
                return;
            }
        }
    }

    static void r_solve(String s, int startIdx) {
        int openCnt = 0;
        int length = 0;
        for (int i = startIdx; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == ')') openCnt++;
            else openCnt--;
            length++;

            if(openCnt == 0) res = Math.max(res, length);
            else if(openCnt < 0) {
                r_solve(s, i-1);
                return;
            }
        }
    }
}
