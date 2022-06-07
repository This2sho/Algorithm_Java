package boj.week3;

import java.util.Scanner;

// 인구 이동
public class N16234 {
    static int[][] A;
    static int N, L, R;
    static int[][] checkMap;
    static boolean[][] visited;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int day = 0;
        while (isMoveable()) {
            int check = 1;

            visited = new boolean[N][N];
            checkMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]) DFS(i, j, check++);
                }
            }

            // checkMap의 값이 같은 것 끼리 합치기
            int[] checkArray = new int[check];
            unionSum(checkArray);
            day++;
        }
//        printMap();
        System.out.print(day);
    }

    static void printMap() {
        for (int[] ints : A) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static boolean canOpen(int x1, int y1, int x2, int y2){
        int abs = Math.abs(A[y1][x1] - A[y2][x2]);
        if(abs >= L && abs<=R) return true;
        return false;
    }

    static boolean isValid(int ny, int nx) {
        if(ny >=N || ny <0 || nx >= N || nx <0) return false;
        return true;
    }

    static boolean isMoveable() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 4; d++) {
                    int ni = i + dy[d];
                    int nj = j + dx[d];
                    if (isValid(ni, nj) && canOpen(i,j,ni,nj)) return true;
                }
            }
        }
        return false;
    }

    static void DFS(int y, int x, int check) {
        visited[y][x] = true;
        checkMap[y][x] = check;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(!isValid(ny, nx) || visited[ny][nx] || !canOpen(x, y, nx, ny)) continue;
            checkMap[ny][nx] = check;
            DFS(ny, nx, check);
        }
    }

    static void unionSum(int[] checkArray) {
        int[] checkCountryNum = new int[checkArray.length];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                checkArray[checkMap[i][j]] += A[i][j];
                checkCountryNum[checkMap[i][j]]++;
            }
        }
        for (int i = 1; i < checkArray.length; i++) {
            checkArray[i] /= checkCountryNum[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(checkMap[i][j] != 0) A[i][j] = checkArray[checkMap[i][j]];
            }
        }
    }
}
