package boj.week5.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 칠무해
public class N14729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            double temp = Double.parseDouble(st.nextToken());
            if(pq.size() >= 7){
                pq.offer(temp);
                pq.poll();
            }else pq.offer(temp);
        }
        pq.stream().sorted().forEach(a -> System.out.printf("%.3f\n",a));
    }
}
