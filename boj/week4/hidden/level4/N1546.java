package boj.week4.hidden.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 평균
public class N1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double m = 0;
        double[] arr = new double[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
            m = Math.max(m, arr[i]);
        }
        for (int i = 0; i < N; i++) arr[i] = arr[i] / m * 100;
        System.out.print(Arrays.stream(arr).summaryStatistics().getAverage());
    }
}
