package boj.week4.hidden.level3;

import java.util.Scanner;

// 합
public class N8393 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.print((N * (N + 1)) / 2);
    }
}
