package boj.week6;

import java.io.*;
import java.util.*;
// 기타 레슨
public class N2343_re {
    static int N, M, result;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        search();
        System.out.print(result);
    }

    static void search() {
        int min = Arrays.stream(arr).max().getAsInt();
        int max = Arrays.stream(arr).sum();

        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;
            int n = 0;
            for (int i : arr) {
                if(sum + i > mid){
                    n++;
                    sum = i;
                }else{
                    sum += i;
                }
            }
            if(n < M){
                result = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
    }
}