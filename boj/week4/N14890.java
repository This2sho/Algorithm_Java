package boj.week4;
import java.io.*;
import java.util.StringTokenizer;

// 경사로
public class N14890 {
    static int N, L;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (checkLoad(i, 0, true)) res++;
            if (checkLoad(0, i, false)) res++;
        }
        System.out.print(res);
    }

    static boolean checkLoad(int y, int x, boolean isRow) {
        int[] load = new int[N];
        boolean[] visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (isRow) {
                load[i] = map[y][i];
            }else{
                load[i] = map[i][x];
            }
        }

        for (int i = 0; i < N - 1; i++) {
            int diff = load[i] - load[i + 1];
            if(diff == 0) continue;
            else if (diff == 1) {
                for (int j = i + 1; j < i + 1 + L; j++) {
                    if(j >= N || load[j] != load[i+1] || visit[j]) return false;
                    visit[j] = true;
                }
            }
            else if(diff == -1) {
                for (int j = i; j > i - L; j--) {
                    if(j < 0 || load[j] != load[i] || visit[j]) return false;
                    visit[j] = true;
                }
            }
            else return false;
        }
        return true;
    }
}