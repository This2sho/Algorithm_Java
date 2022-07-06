package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 소가 길을 건너간 이유 3
public class N14469 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Pos[] arr = new Pos[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        arr = Arrays.stream(arr).sorted((a, b) -> {
            if (a.start == b.start) return a.time - b.time;
            else return a.start - b.start;
        }).toArray(Pos[]::new);

        int end = arr[0].start + arr[0].time;

        for (int i = 1; i < N; i++) {
            if(arr[i].start >= end) end = arr[i].start + arr[i].time;
            else end += arr[i].time;
        }
        System.out.print(end);
    }

    static class Pos{
        int start;
        int time;

        public Pos(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }
}
