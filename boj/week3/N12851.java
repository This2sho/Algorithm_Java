package boj.week3;

import java.util.*;
// 숨바꼭질 2
public class N12851 {
    static int N, K;
    static final int MAX = 100000;
    static int cnt = 0;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];
    static Queue<Integer[]> queue = new LinkedList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        search();
        System.out.println(answer);
        System.out.print(cnt);
    }

    static void search(){
        int pos = N; // 현재 위치
        int time = 0;
        visited[pos] = true;
        queue.add(new Integer[]{pos, time});

        while(!queue.isEmpty()){
            Integer[] now = queue.poll();
            System.out.print("now pos = " + now[0]);
            System.out.println(", time = " + now[1]);
            System.out.println();
            visited[now[0]] = true;

            if(now[1] > answer) break;
            if(now[0] == K){
                answer = now[1];
                cnt++;
                continue;
            }
            if(now[0] + 1 <= MAX && !visited[now[0] + 1]) queue.add(new Integer[]{now[0] + 1, now[1] + 1});
            if(now[0] - 1 >= 0 && !visited[now[0] - 1]) queue.add(new Integer[]{now[0] - 1, now[1] + 1});
            if(now[0] * 2 <= MAX && !visited[now[0] * 2]) queue.add(new Integer[]{now[0] * 2, now[1] + 1});
        }
    }
}
