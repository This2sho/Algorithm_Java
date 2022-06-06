package boj.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 보물섬
public class N2589 {
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
        boolean[] selected = new boolean[lands.size()];
        combination(selected, 0, 0);
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

    static void combination(boolean[] selected, int start, int n) {
        if (n == 2) {
            visited = new boolean[N][M];
            Point begin = new Point(-1, -1, 0);
            Point end = new Point(-1, -1, 0);
            boolean first = true;
            for (int i = 0; i < selected.length; i++) {
                if(selected[i]){
                    if (first) {
                        begin = lands.get(i);
                        first = false;
                    } else end = lands.get(i);
                }
            }
            queue = new LinkedList<>();
            queue.add(begin);
            while(!queue.isEmpty()){
                begin = queue.poll();
                BFS(begin, end);
            }
            return;
        }

        for (int i = start; i < selected.length; i++) {
            selected[i] = true;
            combination(selected, start + 1, n + 1);
            selected[i] = false;
        }
    }

    static void BFS(Point begin, Point end) {
        if (begin.y == end.y && begin.x == end.x) {
            queue = new LinkedList<>();
            answer = Math.max(answer, begin.cnt);
            return;
        }
        if(visited[begin.y][begin.x]) return;
        visited[begin.y][begin.x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = begin.y + dy[i];
            int nx = begin.x + dx[i];

            if(ny >= N || ny <0 || nx >= M || nx <0 || visited[ny][nx] || map[ny][nx] == 0) continue;
            queue.add(new Point(nx, ny,begin.cnt+1));
        }
    }
}
