import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] virusMap;
    static boolean[][] visited;
    static int answer=0;

    static Queue<Integer[]> viruses = new LinkedList<>();
    static Queue<Integer[]> queue = new LinkedList<>();

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    viruses.add(new Integer[]{i, j});
                }
            }
        }
        makeWall(0);
        System.out.print(answer);
    }

    static void makeWall(int depth) {
        if(depth == 3) {
            virusMap = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    virusMap[i][j] = map[i][j];
                }
            }
            queue.addAll(viruses);
            while(!queue.isEmpty()){
                Integer[] poll = queue.poll();
                spreadVirus(poll[0], poll[1]);
            }
            answer = Math.max(answer, checkSafeZone(virusMap));
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void spreadVirus(int y, int x) {
        if(visited[y][x]) return;
        visited[y][x] = true;
        virusMap[y][x] = 2;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= N || ny < 0 || nx >= M || nx <0 || virusMap[ny][nx] != 0 || visited[ny][nx]) continue;
            queue.add(new Integer[]{ny, nx});
        }
    }

    static int checkSafeZone(int[][] map) {
        int cnt = 0;
        for (int[] ints : map) {
            for (int anInt : ints) {
                if(anInt == 0) cnt++;
            }
        }
        return cnt;
    }
}