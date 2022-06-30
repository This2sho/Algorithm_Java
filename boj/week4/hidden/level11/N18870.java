package boj.week4.hidden.level11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// 좌표 압축
public class N18870 {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).distinct().sorted().forEach(a -> map.put(a, cnt++));
        Arrays.stream(arr).forEach(a -> sb.append(map.get(a)+ " "));
        System.out.print(sb);
    }
}
