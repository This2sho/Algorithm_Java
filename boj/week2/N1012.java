package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유기농 배추
public class N1012 {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visitied;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visitied = new boolean[N][M];


            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                map[n][m] = 1;
            }

            for (int k = 0; k < N; k++) {
                for (int l = 0; l < M; l++) {
                    if(map[k][l] == 1 && !visitied[k][l]){
                        DFS(k, l);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void DFS(int y, int x) {
        visitied[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= N || ny <0 || nx >= M || nx < 0) continue;
            if(map[ny][nx] == 1 && !visitied[ny][nx]) DFS(ny, nx);
        }
    }

}
