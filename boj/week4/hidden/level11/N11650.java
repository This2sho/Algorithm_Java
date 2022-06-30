package boj.week4.hidden.level11;

import java.io.*;
import java.util.*;
// 좌표 정렬하기
public class N11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Pos[] arr = new Pos[N];
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            arr[N] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.stream(arr).sorted((a, b) -> {
            if(a.x-b.x == 0) return a.y-b.y;
            else return a.x-b.x;
        }).forEach(o -> System.out.println(o.x + " " + o.y));
    }
    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
