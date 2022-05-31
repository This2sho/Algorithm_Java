package boj.week2;
import java.io.*;
import java.util.*;

public class N1325 {
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited = new boolean[10001];
    static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[B].add(A);
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            dp[i] = DFS(i);
            max = Math.max(max, dp[i]);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) if(max == dp[i]) sb.append(i + " ");
        System.out.print(sb.toString().trim());
    }

    static int DFS(int n) {
        visited[n] = true;
        int cnt = 1;
        for (int next : list[n]) {
            if(visited[next])  continue;
            else cnt += DFS(next);
        }
        return cnt;
    }
}