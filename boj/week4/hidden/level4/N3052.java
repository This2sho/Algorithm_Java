package boj.week4.hidden.level4;

import java.util.Scanner;

// 나머지
public class N3052 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[42];
        int res = 0;
        int t = 10;
        while (t-- > 0) cnt[sc.nextInt() % 42]++;
        for (int i : cnt) if(i > 0) res++;
        System.out.print(res);
    }
}
