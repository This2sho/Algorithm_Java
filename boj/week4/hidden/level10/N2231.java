package boj.week4.hidden.level10;

import java.util.Scanner;

// 분해합
public class N2231 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = 0;
        for (int i = 1; i < N; i++) {
            if (i + getNum(i, 10) == N) {
                res = i;
                break;
            }
        }
        System.out.print(res);
    }

    static int getNum(int n, int start) {
        while ((n / start) >= 10) start *= 10;
        if(start == 1) return n;
        return (n / start) + getNum(n % start, start / 10);
    }
}
