package boj.week3;

import java.util.Scanner;
import java.util.Stack;

// 알파벳
public class N1987 {
    static char[][] map;
    static boolean[][] visited;
    static boolean[] alpha = new boolean[26];
    static int R,C;
    static Stack<int[]> stack = new Stack<>();
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int res = 1;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        visited = new boolean[R][C];
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String next = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = next.charAt(j);
            }
        }

        visited[0][0] = true;
        alpha[map[0][0] - 'A'] = true;
        DFS(0, 0, 1);
        System.out.print(res);
    }

    static void DFS(int y, int x, int cnt) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
            if(alpha[map[ny][nx] - 'A'] || visited[ny][nx]) continue;
            alpha[map[ny][nx] - 'A'] = true;
            visited[ny][nx] = true;
            DFS(ny, nx, cnt + 1);
            alpha[map[ny][nx] - 'A'] = false;
            visited[ny][nx] = false;
        }
        res = Math.max(res, cnt);
        if(res == 26) return;
    }
}
