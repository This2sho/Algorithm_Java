package boj.week3;
import java.io.*;
import java.util.*;
// 숨바꼭질 4
public class N13913 {
    static int N, K;
    static final int MAX = 100000;
    static boolean[] visited = new boolean[100001];
    static Queue<Integer[]> queue = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)  throws IOException{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        search();
    }

    static void search() throws IOException{
        queue.add(new Integer[] {N, 0});
        visited[N] = true;
        int[] prev = new int[100001];


        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            Integer nowPos = now[0];
            if(nowPos == K){
                bw.write(now[1] + "\n");
                for (int i = K; i != N; i = prev[i]) stack.push(i);
                stack.push(N);
                while(!stack.empty()){
                    bw.write(stack.pop() + " ");
                }
                bw.flush();
                break;
            }
            for (int next : new int[] {nowPos + 1, nowPos - 1, nowPos * 2}) {
                if(next > MAX || next < 0 || visited[next]) continue;
                queue.offer(new Integer[] {next, now[1] + 1});
                visited[next] = true;
                prev[next] = nowPos;
            }
        }
    }
}
