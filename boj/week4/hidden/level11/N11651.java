package boj.week4.hidden.level11;

import java.io.*;
import java.util.*;

// 좌표 정렬하기 2
public class N11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        Pos[] arr = new Pos[N];
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            arr[N] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.stream(arr).sorted((a, b) -> {
            if(a.y-b.y == 0) return a.x-b.x;
            else return a.y-b.y;
        }).forEach(o -> sb.append(o.x + " " + o.y + "\n"));
        System.out.print(sb.toString().trim());
    }
    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
