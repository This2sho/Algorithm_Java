package boj.week6.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 보석 상자
public class N2792_re {
    static int max;
    static int[] colors;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        colors = new int[M];
        for (int i = 0; i < M; i++) {
            colors[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, colors[i]);
        }
        System.out.print(search(N));
    }

    static int search(int n) {
        int min = Integer.MAX_VALUE;
        int low = 1; // 질투심의 최소는 1
        int high = max; // 질투심의 최대 범위

        while (low <= high) {
            int mid = (low + high) / 2; // 최대 질투심
            int sum = 0;

            for (int color : colors) {
                int people = color % mid == 0 ? color / mid : color / mid + 1;
                sum += people;
            }

            if (n >= sum) {
                min = Math.min(min, mid);
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return min;
    }


}
