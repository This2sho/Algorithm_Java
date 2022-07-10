package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스타트와 링크
public class N14889 {
    static int N, result = Integer.MAX_VALUE;
    static int[][] ability;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) ability[i][j] = Integer.parseInt(st.nextToken());
        }
        solve(0, new boolean[N], 0);
        System.out.print(result);
    }

    static void solve(int depth, boolean[] visited, int start) {
        if(depth >= N/2){
            int temp = 0;
            int other = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i] && visited[j] && i != j) temp += ability[i][j];
                    else if(!visited[i] && !visited[j] && i != j) other += ability[i][j];
                }
            }
            if(temp == 0) return;
            result = Math.min(result, Math.abs(temp - other));
            return;
        }

        for (int i = start; i < N; i++) {
            System.out.println("i = " + i);
            visited[i] = true;
            solve(depth+1, visited, i+1);
            visited[i] = false;
        }
    }

}
