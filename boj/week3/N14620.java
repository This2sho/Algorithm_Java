package boj.week3;

import java.util.Scanner;
// 꽃길
public class N14620 {
    static int N;
    static int[][] cost, cache;
    static boolean[][] visited;
    static int res = Integer.MAX_VALUE;
    static final int[] dy = {0, -1, 0, 1, 0};
    static final int[] dx = {0, 0, 1, 0, -1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cost = new int[N][N];
        cache = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        initCache();
        solve(0, 0, 1, 1);
        System.out.print(res);
    }

    static void initCache() {
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                for (int d = 0; d < 5; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    cache[i][j] += cost[ny][nx];
                }
            }
        }
    }

    static void solve(int depth, int sum, int startY, int startX) {
        if (depth == 3) {
            res = Math.min(sum, res);
            return;
        }

        for (int i = startY; i < N - 1; i++) {
            next : for (int j = i==startY ? startX : 1; j < N - 1; j++) {
                for (int d = 0; d < 5; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if(!isValid(ny, nx)) continue next;
                }
                checkVisit(i, j, true);
                solve(depth+1, sum + cache[i][j], i, j+1);
                checkVisit(i, j, false);
            }
        }
    }

    private static void checkVisit(int i, int j, boolean b) {
        for(int d = 0; d < 5; d++){
            int ny = i + dy[d];
            int nx = j + dx[d];
            visited[ny][nx] = b;
        }
    }

    static boolean isValid(int y, int x) {
        if(y<0 || y>=N || x <0 || x>=N || visited[y][x]) return false;
        return true;
    }

    static void printMap() {
        for (int[] ints : cache) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
