package boj.week4.hidden.level10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 블랙잭
public class N2798 {
    static int[] nums;
    static int N, M;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        solve(0, new int[3], 0);
        System.out.print(res);
    }

    static void solve(int start, int[] arr, int depth) {
        if (depth == 3) {
            int sum = Arrays.stream(arr).sum();
            if(sum <= M) res = Math.max(res, sum);
            return;
        }
        for (int i = start; i < N; i++) {
            arr[depth] = nums[i];
            solve(i + 1, arr, depth + 1);
        }
    }
}
