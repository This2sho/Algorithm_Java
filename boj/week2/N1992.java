package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 쿼드트리
public class N1992 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.print(quad(N, map));
    }

    public static String quad(int n, int[][] map){
        boolean allSame = true;
        int half = n/2;
        int[][] quad_map = new int[half][half];
        String answer ="(";
        int[][] di = {{0, half}, {0, half}, {half, n}, {half, n}};
        int[][] dj = {{0, half}, {half, n}, {0, half}, {half, n}};

        for (int d = 0; d < 4; d++) {
            boolean same = true;
            int value = map[di[d][0]][dj[d][0]];
            for(int i=di[d][0] , k=0; i<di[d][1]; k++, i++) {
                for (int j = dj[d][0], l=0; j < dj[d][1]; l++, j++) {
                    quad_map[k][l] = map[i][j];
                    if(map[0][0] != map[i][j]) allSame = false;
                    if(map[i][j] != value) {
                        same = false;
                    }
                }
            }
            if(!same){
                answer += quad(half, quad_map);
            }
            else answer += value;
        }

        if(allSame) return map[0][0] + "";
        return answer + ")";
    }
}
