package boj.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 막대기
public class N1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int res = 0;
        for (int i = 1; i < 1 << 7; i *= 2) {
            if((X & i) > 0) res++;
        }
        System.out.print(res);
    }
}
