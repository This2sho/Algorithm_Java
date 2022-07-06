package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 컵라면
public class N1781_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Cup[] cups = new Cup[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cups[i] = new Cup(d, c);
        }
        cups = Arrays.stream(cups).sorted((a, b) -> {
            if (a.deadLine == b.deadLine) return a.cupCnt - b.cupCnt;
            else return a.deadLine - b.deadLine;
        }).toArray(Cup[]::new);

        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            res += cups[i].cupCnt;
            pq.offer(cups[i].cupCnt);
            if (pq.size() > cups[i].deadLine) res -= pq.poll();
        }
        System.out.print(res);
    }

    static class Cup{
        int deadLine;
        int cupCnt;

        public Cup(int deadLine, int cupSize) {
            this.deadLine = deadLine;
            this.cupCnt = cupSize;
        }
    }
}