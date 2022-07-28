package boj.week5;
import java.io.*;
import java.util.StringTokenizer;
// 원판 돌리기
public class N17822 {
    static int N, M, T;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N+1][M];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        RotateInfo[] rotateInfos = new RotateInfo[T];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            rotateInfos[i] = new RotateInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < T; i++) {
            rotate(rotateInfos[i]);
            delete();
        }
        System.out.print(stat()[0]);
    }

    static class RotateInfo {
        int x, d, k;

        public RotateInfo(int x, int d, int k) {
            this.x = x;
            this.d = d;
            this.k = k;
        }
    }

    static void rotate(RotateInfo info) {
        for (int i = 1; i <= N; i++) {
            if (i % info.x == 0) {
                int[] tmp = new int[M];
                for (int j = 0; j < M; j++) {
                    if(info.d == 0) tmp[(j + info.k) % M] = map[i][j];
                    else tmp[(M - (info.k - j)) % M] = map[i][j];
                }
                map[i] = tmp;
            }
        }
    }

    static void delete() {
        int same = 1;
        int[][] tmp = new int[N + 1][M];
        for(int i=1; i<=N; i++) System.arraycopy(map[i], 0, tmp[i], 0, M);
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) continue;
                if(j == 0 && map[i][j] == map[i][M-1]) tmp[i][j] = tmp[i][M-1] = same = 0;

                if(j != 0 && map[i][j] == map[i][j-1]) tmp[i][j] = tmp[i][j-1] = same = 0;
                if(j != M-1 && map[i][j] == map[i][j+1]) tmp[i][j] = tmp[i][j+1] = same = 0;

                if(i != 1 && map[i][j] == map[i-1][j]) tmp[i][j] = tmp[i-1][j] = same = 0;
                if(i != N && map[i][j] == map[i+1][j]) tmp[i][j] = tmp[i+1][j] = same = 0;
            }
        }
        map = tmp;

        if (same == 1) {
            int[] stat = stat();
            double avg = (double) stat[0] / stat[1];
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0) continue;
                    if(map[i][j] < avg) map[i][j]++;
                    else if(map[i][j] > avg) map[i][j]--;
                }
            }
        }
    }

    static int[] stat() {
        int[] stat = new int[2];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) continue;
                stat[0] += map[i][j];
                stat[1]++;
            }
        }
        return stat;
    }
}