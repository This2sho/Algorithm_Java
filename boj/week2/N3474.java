package boj.week2;

import java.util.Scanner;

// 교수가 된 현우
public class N3474 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        for (int i = 0; i < N; i++) {
            long k = sc.nextLong();
            long cnt5 = 0;
            for (long j = 5; j <= k; j *= 5) cnt5 += k / j;
            System.out.println("cnt5 = " + cnt5);
        }
    }

}

