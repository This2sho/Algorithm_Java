package boj.week3;
import java.util.Scanner;
// 컴백홈
public class N1189 {
    static int R, C, K;
    static boolean map[][], visited[][];
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int res = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        map = new boolean[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String next = sc.next();
            for (int j = 0; j < C; j++) {
                if(next.charAt(j) != 'T') map[i][j] = true;
            }
        }
        visited[R-1][0] = true;
        solve(1, R-1, 0);
        System.out.print(res);
    }

    static void solve(int depth, int y, int x) {
        if(depth == K){
            if(visited[0][C-1]) res++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= R || nx <0 || nx >=C || !map[ny][nx] || visited[ny][nx]) continue;
            if(depth < K-1 && ny == 0 && nx == C-1) continue;
            visited[ny][nx] = true;
            solve(depth+1, ny, nx);
            visited[ny][nx] = false;
        }
    }

    static void print() {
        for (boolean[] booleans : visited) {
            for (boolean aBoolean : booleans) {
                System.out.print(aBoolean + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}