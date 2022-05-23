package boj.week1;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

// 수열
public class N2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N + 1];
        int[] psum = new int[N + 1];
        int[] ksum = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = sc.nextInt();
            psum[i] = psum[i - 1] + arr[i];
        }

        for (int i = K; i < N + 1; i++) {
            ksum[i] = psum[i] - psum[i - K];
        }

        System.out.print(Arrays.stream(Arrays.copyOfRange(ksum, K, ksum.length)).max().getAsInt());
    }
}
