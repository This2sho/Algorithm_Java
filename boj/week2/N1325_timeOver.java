package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 효율적인 해킹
public class N1325_timeOver {
    static int N, M;
    static LinkedList<LinkedList<Integer>> computers = new LinkedList<>();
    static HashMap<Integer, Integer> countMap = new HashMap<>();
    static Stack<Integer> stack = new Stack<>();
    static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new int[N+4];
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            computers.add(i, new LinkedList<>());
            if(i!=0) countMap.put(i, 0);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken()); // A가 B를 신뢰한다.
            computers.get(B).add(A);
            countMap.put(B, countMap.get(B) + 1);
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            if(visited[i] == 0) visited[i] = DFS(i);
            max = Math.max(visited[i], max);
            countMap.put(i, visited[i]);
        }
        for (int i=1; i<=N; i++) {
            if(visited[i] == max) System.out.print(i + " ");
        }
    }

    static int DFS(int n) {
        if(visited[n] != 0) return visited[n];
        stack.addAll(computers.get(n));
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            visited[n] = countMap.get(n) + DFS(pop);
            return visited[n];
        }
        return visited[n] = 1;
    }
}
