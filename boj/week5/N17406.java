package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 배열 돌리기 4
public class N17406 {
    static int res = Integer.MAX_VALUE;
    static int N, M, K;
    static ArrayList<int[]> rotateList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rotateList.add(new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())});
        }

        solve(0, new boolean[K], arr);
        System.out.print(res);
    }

    static void printArr(int[][] temp) {
        for (int[] ints : temp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void solve(int depth, boolean[] visited, int[][] temp) {
        if (depth == K) {
            res = Math.min(res, getMin(temp));
            return;
        }
        for (int i = 0; i < K; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            solve(depth + 1, visited, rotateArr(temp, rotateList.get(i)));
            visited[i] = false;
        }
    }

    static int[][] rotateArr(int[][] temp, int[] rotate) {
        int[][] next = new int[N][M];
        for(int i=0; i<N; i++) System.arraycopy(temp[i], 0, next[i], 0, M);
        int leftRow = rotate[0] - rotate[2];
        int leftCol = rotate[1] - rotate[2];
        int rightRow = rotate[0] + rotate[2];
        int rightCol = rotate[1] + rotate[2];

        while (leftRow != rightRow) {
            for (int j = leftCol + 1; j <= rightCol; j++) next[leftRow][j] = temp[leftRow][j - 1];
            for (int i = leftRow + 1; i <= rightRow; i++) next[i][rightCol] = temp[i - 1][rightCol];
            for (int j = rightCol - 1; j >= leftCol; j--) next[rightRow][j] = temp[rightRow][j + 1];
            for (int i = rightRow - 1; i >= leftRow; i--) next[i][leftCol] = temp[i + 1][leftCol];
            leftRow++; leftCol++; rightRow--; rightCol--;
        }
        return next;
    }

    static int getMin(int[][] temp) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) min = Math.min(min, Arrays.stream(temp[i]).sum());
        return min;
    }
}
