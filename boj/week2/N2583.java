package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 영역 구하기
public class N2583 {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int[] cnt = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int[] pos1 = new int[]{Integer.parseInt(st.nextToken()), M - Integer.parseInt(st.nextToken())};
            int[] pos2 = new int[]{Integer.parseInt(st.nextToken()), M - Integer.parseInt(st.nextToken())};
            // 좌표를 그래프에 맞게 : (0, 0) -> (0, 5) , (7, 5) -> (7, 0) => x는 그대로 y는 5 - y
            // (x : 7, y : 5) : (0, 2) , (4, 4) -> (0, 3) , (4, 1) x 길이는 pos2[0] - pos1[0] = 4, y 길이는 pos1[1] - pos2[1] = 2
            // x의 시작과 끝은? (pos1[0], pos2[1]) -> x길이 , y 길이
            int xLength = pos2[0] - pos1[0];
            int yLength = pos1[1] - pos2[1];

            for (int y = pos2[1]; y < pos1[1]; y++) {
                for (int x = pos1[0]; x < pos2[0]; x++) {
                    map[y][x] = 1;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    DFS(i, j, answer);
                    answer ++;
                }
            }
        }

        System.out.println(answer);
        int[] ans = Arrays.stream(cnt).filter(a -> a != 0).sorted().toArray();
        for (int i=0; i<answer; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void DFS(int y, int x, int answer) {
        visited[y][x] = true;
        cnt[answer] ++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx <0 || nx >= N || ny < 0 || ny >= M) continue;
            if(map[ny][nx] == 0 && !visited[ny][nx]) DFS(ny, nx, answer);
        }
    }
}
