package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 연속합
public class N1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] pSum = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            pSum[i] = sum;
        }
        System.out.print(Arrays.stream(pSum).max().getAsInt());
    }
}
