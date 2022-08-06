package boj.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 용돈 관리
public class N6236 {
    static int N, M, result;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        binarySearch();
        System.out.print(result);
    }

    static void binarySearch() {
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isRight(mid)) {
                result = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
    }

    private static boolean isRight(int mid) {
        int cnt = 1;
        int sum = 0;

        for (int dailyMoney : arr) {
            if (sum + dailyMoney > mid) {
                cnt++;
                sum = dailyMoney;
            }else sum += dailyMoney;
        }
        return cnt <= M;
    }
}
