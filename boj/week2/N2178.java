package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
public class N2178 {
    static boolean[][] map;
    static int[][] visited;
    static int N, M;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static Queue<Integer[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if(s.charAt(j) == '1') map[i][j]=true;
                else map[i][j] = false;
            }
        }

        queue.add(new Integer[]{0, 0});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            BFS(poll[0], poll[1]);
        }

        System.out.print(visited[N-1][M-1]);
    }

    public static void BFS(int y, int x) {
        if(y == N && x == M) return;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= N || ny <0 || nx>=M || nx <0 || !map[ny][nx]) continue;
            if(visited[ny][nx] > 0) continue;

            queue.add(new Integer[]{ny, nx});
            visited[ny][nx] = visited[y][x] + 1;
        }
    }
}
