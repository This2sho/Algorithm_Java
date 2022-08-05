package boj.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 기타 레슨
public class N2343_re {
    static int N, M, result;
    static int[] arr, pSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        pSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
        search();
        System.out.print(result);
    }

    static void search() {
        int min = Arrays.stream(arr).max().getAsInt();
        int max = Arrays.stream(arr).sum();

        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;
            int n = 1;
            for (int i : arr) {
                if(sum + i > mid){
                    n++;
                    sum = i;
                }else{
                    sum += i;
                }
            }
            if(n <= M){
                if(n==M) result = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
    }
}
