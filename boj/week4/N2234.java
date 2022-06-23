package boj.week4;
import java.io.*;
import java.util.*;
// 성곽
public class N2234 {
    static int N, M;
    static int roomCnt = 0;
    static int[][] map;
    static final int[] dy = {0, -1, 0, 1};
    static final int[] dx = {-1, 0, 1, 0};
    static int[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new int[M][N];
        int[] roomSizes = new int[2501];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = ++roomCnt;
                    roomSizes[roomCnt] = searchSize(roomCnt);
                }
            }
        }
        System.out.println(roomCnt);
        System.out.println(Arrays.stream(roomSizes).max().getAsInt());
        int res = 2;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 4; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if(ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
                    if (visited[i][j] != visited[ny][nx]) {
                        res = Math.max(res, roomSizes[visited[i][j]] + roomSizes[visited[ny][nx]]);
                    }
                }
            }
        }
        System.out.print(res);
    }

    static int searchSize(int roomCnt) {
        int size = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];
                if(ny < 0 || ny >= M || nx < 0 || nx >= N || visited[ny][nx] != 0 || (map[poll[0]][poll[1]] & 1 << i) > 0) continue;
                visited[ny][nx] = roomCnt;
                size++;
                queue.add(new int[]{ny, nx});
            }
        }
        return size;
    }
}