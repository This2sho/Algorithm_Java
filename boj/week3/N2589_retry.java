package boj.week3;

import java.io.*;
import java.util.*;

// 보물섬
public class N2589_retry {
    static int[][] map;
    static int answer = 0;
    static int N, M;
    static boolean[][] visited;
    static List<Point> lands = new LinkedList<>();
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                if(temp.charAt(j) == 'W'){ map[i][j] = 0;}
                else{
                    map[i][j] = 1;
                    lands.add(new Point(j, i, 0));
                }
            }
        }
        //todo 땅 2개를 선택하는 알고리즘
        for (Point land : lands) {
            queue = new LinkedList<>();
            queue.add(land);
            visited = new boolean[N][M];
            int val = BFS(land);
            answer = Math.max(answer, val);
        }
        System.out.print(answer);

    }

    static class Point{
        int x, y, cnt;
        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int BFS(Point begin) {
        visited[begin.y][begin.x] = true;
        while(!queue.isEmpty()) {
            begin = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = begin.y + dy[i];
                int nx = begin.x + dx[i];
                if (ny >= N || ny < 0 || nx >= M || nx < 0 || visited[ny][nx] || map[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                queue.add(new Point(nx, ny, begin.cnt + 1));
            }
        }
        return begin.cnt;
    }
}