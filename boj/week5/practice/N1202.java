package boj.week5.practice;
// 보석 도둑

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 보석 개수 N개
 * 각 보석의 무게 Mi, 가격 Vi
 * 가방의 개수 K개 (가방에는 최대 1개 보석)
 * 각 가방에 담을 수 있는 무게 Ci
 */
public class N1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jew[] jews = new Jew[N];
        int[] C = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jews[i] = new Jew(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < K; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }
        jews = Arrays.stream(jews).sorted((a, b) -> {if(a.M==b.M) return a.V-b.V; else return a.M-b.M;}).toArray(Jew[]::new);
        Arrays.sort(C);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        long res = 0;
        for (int i = 0; i < K; i++) {
            while(j < N && jews[j].M <= C[i]) pq.offer(jews[j++].V);
            if(!pq.isEmpty()) res += pq.poll();
        }
        System.out.print(res);
    }

    static class Jew {
        int M;
        int V;
        public Jew(int m, int v) {
            M = m;
            V = v;
        }
    }
}
