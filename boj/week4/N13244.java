package boj.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N13244 {
    static int N, M;
    static boolean[] visited;
    static boolean isTree = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        next : for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            visited = new boolean[N+1];
            isTree = true;
            ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
            for(int k=0; k<N+1; k++) tree.add(new ArrayList<>());
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());

                int B = Integer.parseInt(st.nextToken());
                if(tree.get(A).contains(B) || tree.get(B).contains(A)) isTree = false;
                tree.get(A).add(B);
                tree.get(B).add(A);
            }
            visited[1] = true;
            solve(tree, 1);
            for(int n=1; n<=N; n++){
                if(!visited[n]){
                    isTree = false;
                    break;
                }
            }
            if(isTree) System.out.println("tree");
            else System.out.println("graph");
        }
    }

    static void solve(ArrayList<ArrayList<Integer>> tree, int cur) {
        ArrayList<Integer> arrayList = tree.get(cur);
        for (Integer node : arrayList) {
            if(visited[node]){
                isTree = false;
                return;
            }
            visited[node] = true;
            tree.get(node).remove((Integer) cur);
            solve(tree, node);
        }
    }
}
