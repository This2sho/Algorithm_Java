package boj.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열
public class N11053 {
    static int[] arr, lis, idxArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        lis = new int[N];
        idxArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        lis[0] = arr[0];
        idxArr[0] = 0;
        int curIdx = 0;

        for (int i = 1; i < N; i++) {
            if (lis[curIdx] < arr[i]) {
                idxArr[i] = curIdx + 1;
                lis[++curIdx] = arr[i];
            }else{
                int idx = binarySearch(0, curIdx, arr[i]);
                idxArr[i] = idx;
                lis[idx] = arr[i];
            }
        }
        System.out.print((Arrays.stream(idxArr).max().getAsInt() + 1));
    }


    static int binarySearch(int left, int right, int value) {
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (lis[mid] < value) {
                left = mid + 1;
            }else{
                idx = mid;
                right = mid -1;
            }
        }
        return idx;
    }
}
