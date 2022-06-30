package boj.week4.hidden.level12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 카드 2
public class N10816 {
    static int[] cnt = new int[20000004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(N-->0) cnt[Integer.parseInt(st.nextToken()) + 10000000]++;
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) sb.append(cnt[Integer.parseInt(st.nextToken()) + 10000000] + " ");
        System.out.print(sb);
    }
}
