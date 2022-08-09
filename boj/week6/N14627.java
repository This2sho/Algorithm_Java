package boj.week6;
import java.io.*;
import java.util.*;
// 파닭파닭
public class N14627 {
    static int S, C;
    static long sum, result;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[S];
        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        binarySearch();
        System.out.print((sum - result * C));
    }

    static void binarySearch() {
        long low = 1;
        long high = Arrays.stream(arr).max().getAsInt();

        while (low <= high) {
            long mid = (low + high) / 2;
            int cnt = 0;

            for (int i : arr) cnt += i / mid;

            if (cnt >= C) {
                result = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
    }
}
