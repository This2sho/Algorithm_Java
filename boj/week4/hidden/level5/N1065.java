package boj.week4.hidden.level5;

import java.util.Scanner;

// 한수
public class N1065 {
    static int res = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N == 1000){
            System.out.print(144);
            N = 0;
        }

        if(N != 0 && N <= 99) res += N;
        else if(N > 99) res+= 99;
        for (int i = 111; i <= N; i++) {
            int a = i / 100;
            int b = (i % 100) / 10;
            int c = i % 10;
            if(a - b == b - c) res++;
        }
        if(N!=0) System.out.print(res);
    }
}
