package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 흙길 보수하기
public class N1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Pos[] pos = new Pos[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(pos);
        int end = 0, res = 0;
        for (Pos po : pos) {
            if(po.end <= end) continue;
            if (po.start > end) {
                int b = (po.end - po.start) / L + (((po.end - po.start) % L) > 0 ? 1 : 0);
                res += b;
                end = po.start + b * L;
            }else{
                int b = (po.end - end) / L + (((po.end - end) % L) > 0 ? 1 : 0);
                res += b;
                end = end + b * L;
            }
        }
        System.out.print(res);
    }

    static class Pos implements Comparable<Pos> {
        int start;
        int end;

        public Pos(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.start == o.start) return this.end - o.end;
            return this.start - o.start;
        }
    }
}
