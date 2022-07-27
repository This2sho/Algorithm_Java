package boj.week5;
import java.io.*;
import java.util.*;

// 감시
public class N15683 {
    static int N, M;
    static int res;
    static LinkedList<int[]> list = new LinkedList<>();
    static final int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static final int[] r = {-1, 4, 2, 4, 4, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = N * M;
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) list.add(new int[]{i, j, map[i][j]});
            }
        }
        solve(map, 0);
        System.out.print(res);
    }

    static void solve(int[][] map, int depth) {
        if (depth == list.size()) {
            int sum = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == 0) sum++;
                }
            }
            res = Math.min(res, sum);
            return;
        }
        else {
            int[] poll = list.get(depth);
            int c = poll[2];
            for (int i = 0; i < r[c]; i++) {
                boolean[] direction = new boolean[4];
                if (c == 1) direction[i] = true;
                else if (c == 2) direction[i] = direction[i + 2] = true;
                else if (c == 3) direction[i] = direction[(i + 1) % 4] = true;
                else if (c == 4) {
                    direction = new boolean[]{true, true, true, true};
                    direction[i] = false;
                } else if (c == 5) direction = new boolean[]{true, true, true, true};
                int[][] tmp = copyMap(map);
                solve(go(map, poll, direction), depth+1);
                map = tmp;
            }
        }
    }

    static int[][] go(int[][] tmp, int[] pos, boolean[] direction) {
        int cam = tmp[pos[0]][pos[1]];
        for (int i = 0; i < 4; i++) {
            int ny = pos[0] + d[i][0];
            int nx = pos[1] + d[i][1];
            if (direction[i]) {
                while (ny >= 0 && ny < N && nx >= 0 && nx < M && tmp[ny][nx] != 6) {
                    tmp[ny][nx] = cam;
                    ny += d[i][0];
                    nx += d[i][1];
                }
            }
        }
        return tmp;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) tmp[i][j] = map[i][j];
        }
        return tmp;
    }
}