package boj.week5.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 선긋기
public class N2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Pos[] L = new Pos[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            L[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        L = Arrays.stream(L).sorted((a, b) -> {
            if (a.start == b.start) return a.end - b.end;
            else return a.start - b.start;}).toArray(Pos[]::new);
        int start = L[0].start;
        int end = L[0].end;
        int res = 0;
        for (int i = 1; i < N; i++) {
            if (end < L[i].start) {
                res += (end - start);
                start = L[i].start;
                end = L[i].end;
            } else if (L[i].start <= end && L[i].end >= end) {
                end = L[i].end;
            }
        }
        res += end - start;
        System.out.print(res);
    }

    static class Pos{
        int start;
        int end;

        public Pos(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
