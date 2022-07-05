package boj.week5.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 두수의 합
public class N3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] =  Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int i = 0;
        int j = n - 1;
        int res = 0;
        while (i < j && i<n && i >= 0) {
            int sum = arr[i] + arr[j];
            if(sum == x) {
                res++; i++; j--;
            }
            else if(sum < x) i++;
            else j--;
        }
        System.out.print(res);
    }
}
