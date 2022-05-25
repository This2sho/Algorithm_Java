package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExDFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // y x = 1, 0  | 0, 1 | -1, 0 | 0, -1


        adj = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) adj[i][j] = true;
                else adj[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(adj[i][j]){
                    DFS(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    public static int count = 0;
    static boolean[][] adj;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    public static void DFS(int y, int x){
        if(!adj[y][x]) return;

        adj[y][x] = false;
        System.out.println("DFS => " + y +", " + x);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= adj.length || nx >= adj[0].length) continue;
            DFS(ny, nx);
        }
    }
}
