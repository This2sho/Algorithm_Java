package boj.week6;
import java.io.*;
import java.util.*;
// 놀이공원
public class N1561 {
    static int M;
    static long N, result;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++) arr[i] = Integer.parseInt(st.nextToken());
        if(N <= M) System.out.print(N);
        else{
            binarySearch();
            printNum();
        }
    }

    private static void printNum() {
        int b = M;
        for (int i=1; i<=M; i++) b += (result-1) / arr[i];
        long last = N - b;
        int cnt = 0;
        for (int i=1; i<=M; i++) {
            if(result % arr[i] == 0) cnt++;
            if (cnt == last) {
                System.out.print(i);
                return;
            }
        }
    }

    static void binarySearch() {
        long low = 0;
        long high = (N / M) * Arrays.stream(arr).max().getAsInt();

        while (low <= high) {
            long mid = (low + high) / 2;
            long cnt = M;
            for (int i =1; i<=M; i++) {
                cnt += mid / arr[i];
            }
            if (cnt >= N) {
                result = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
    }
}