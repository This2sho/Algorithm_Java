package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 치즈
public class N2636 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Integer[]> queue = new LinkedList<>();
    static int cheese = 0;
    static int time = 0;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cheese++;
            }
        }
        int answer = 0;



        while (cheese > 0) {
            time++;
            answer = cheese;
            visited = new boolean[N][M];
            queue.add(new Integer[]{0, 0});
            visited[0][0] = true;
            BFS();
        }

        System.out.println("time = " + time);
        System.out.println("answer = " + answer);
    }

    static void BFS() {
        while(!queue.isEmpty()){
            Integer[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
                if(map[ny][nx] == 1){
                    cheese--;
                    map[ny][nx] = 0;
                }else if(map[ny][nx] == 0){
                    queue.add(new Integer[]{ny, nx});
                }
                visited[ny][nx] = true;
            }
        }
    }

    static void printMap() {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("=============");
    }
}
