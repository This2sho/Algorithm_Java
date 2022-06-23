package boj.week4;
import java.io.*;
import java.util.StringTokenizer;
// 종이 조각
public class N14391 {
    static int N, M;
    static int[][] map;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        dfs(0, new int[N]);
        System.out.print(res);
    }

    static void dfs(int depth, int[] rowInfo) {
        if (depth == N) {
            int sum = 0;
            int[] colInfo = new int[M];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if ((rowInfo[j] & 1 << M-i-1) == 0) {
                        colInfo[i] |= 1 << N - j - 1;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                sum += getNum(i, true, rowInfo[i]);
            }
            for (int i = 0; i < M; i++) {
                sum += getNum(i, false, colInfo[i]);
            }
            res = Math.max(sum, res);
            return;
        }
        for (int i = 0; i < 1 << M; i++) {
            rowInfo[depth] = i;
            dfs(depth+1, rowInfo);
        }
    }

    static int getNum(int r, boolean isRow, int info) {
        int num = 0;
        int sum = 0;
        if (isRow) {
            for (int i = 0; i < M; i++) {
                if ((info & (1 << M - i - 1)) > 0) {
                    num *= 10;
                    num += map[r][i];
                } else {
                    sum += num;
                    num = 0;
                }
            }
        }else{
            for (int i = 0; i < N; i++) {
                if ((info & (1 << N - i - 1)) > 0) {
                    num *= 10;
                    num += map[i][r];
                } else {
                    sum += num;
                    num = 0;
                }
            }
        }
        if(num != 0) sum += num;
        return sum;
    }
}
