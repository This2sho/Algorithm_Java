package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EXBFS {
    static int N, M, beginY, beginX, endY, endX;
    static Queue<Integer[]> queue = new LinkedList<>();
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static boolean[][] map;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        beginY = Integer.parseInt(st.nextToken());
        beginX = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        endY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        cost = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) map[i][j] = true;
                else map[i][j] = false;
            }
        }

        queue.add(new Integer[] {0, 0});
        cost[0][0] = 1;

        while (!queue.isEmpty()) {
            Integer[] integers = queue.poll();
            DFS(integers[0], integers[1]);
        }

        for (int[] ints : cost) {
            for (int anInt : ints) {
                System.out.print(anInt + ", ");
            }
            System.out.println();
        }

    }

    public static void DFS(int y, int x) {
        if(y == endY && x==endX) return;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= N || ny <0 || nx >= M || nx < 0) continue;
            if(!map[ny][nx]) continue;

            map[y][x] = false;
            Integer[] temp = {ny, nx};
            System.out.println(ny + ", " + nx);
            queue.add(temp);
            cost[ny][nx] = cost[y][x] + 1;
        }
    }

}
