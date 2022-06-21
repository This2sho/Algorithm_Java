package boj.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1987_bitmasking {
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int R, C;
    static char[][] map;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int visited = 0;
        visited |= 1 << (map[0][0] - 'A');
        dfs( 0,0, visited, 1);
        System.out.print(res);
    }

    static void dfs(int y, int x, int visited, int cnt) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
            if((visited & (1 << map[ny][nx] - 'A')) > 0) continue;
            dfs( ny, nx, visited | (1 << (map[ny][nx] - 'A')), cnt+1);
        }
        res = Math.max(res, cnt);
    }
}
