package boj.week3;
import java.util.*;
// 주난의 난
public class N14497 {
    static int N, M;
    static Queue<int[]> queue = new LinkedList<>();
    static int x1, x2, y1, y2;
    static char[][] map;
    static int cnt = 0;
    static int[][] visited;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        visited = new int[N][M];
        y1 = sc.nextInt()-1;
        x1 = sc.nextInt()-1;
        y2 = sc.nextInt()-1;
        x2 = sc.nextInt()-1;
        queue.add(new int[]{y1, x1});
        visited[y1][x1] = 1;
        for (int i = 0; i < N; i++) {
            String next = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = next.charAt(j);
            }
        }
        solve();
        System.out.print(visited[y2][x2]);
    }

    static void print() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void solve() {
        Queue<int[]> temp = new LinkedList<>();
        while (map[y2][x2] != '0') {
            cnt++;
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = poll[0] + dy[i];
                    int nx = poll[1] + dx[i];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] != 0) continue;
                    visited[ny][nx] = cnt;
                    if (map[ny][nx] != '0') {
                        map[ny][nx] = '0';
                        temp.offer(new int[]{ny, nx});
                    } else queue.offer(new int[]{ny, nx});
                }
            }
            queue.addAll(temp);
        }
    }
}

/**
 *
 * 1 # 1 0 1 1 1
 * 1 1 0 0 0 0 1
 * 0 0 0 * 0 1 1
 * 1 1 0 0 1 1 1
 * 0 0 1 1 0 0 1
 *
 * 1 # ! 0 ! ! 1
 * ! ! 0 0 0 0 !
 * 0 0 0 * 0 ! 1
 * ! ! 0 0 ! 1 1
 * 0 0 ! ! 0 0 1
 *
 * 1 # 0 0 0 0 1
 * 0 0 0 0 0 0 0
 * 0 0 0 * 0 0 1
 * 0 0 0 0 0 1 1
 * 0 0 0 0 0 0 1
 */







