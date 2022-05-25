package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 안전영역
public class N2468 {
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int[] ints : map) {
            max = Math.max(max, Arrays.stream(ints).max().orElse(0));
        }

        int[] answer = new int[max+1];
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][k] > i && !visited[j][k]) {
                        answer[i]++;
                        DFS(j, k, i);
                    }
                }
            }
            visited = new boolean[N][N];
        }

        System.out.print(Arrays.stream(answer).max().orElse(0));
    }

    public static void DFS(int y, int x, int h) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= N || ny <0 || nx >= N || nx <0) continue;
            if(map[ny][nx] > h && !visited[ny][nx]) DFS(ny, nx, h);
        }
    }
}
