package boj.week3;
import java.util.*;
// 숨바꼭질 5
public class N17071 {
    static int N, K;
    static boolean[][] visited = new boolean[2][500001];
    final static int MAX = 500000;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        System.out.print(search());
    }

    static int search() {
        queue.add(new int[]{N, 0, K});
        visited[0][N] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[2] > MAX) return -1;
            if (visited[now[1] % 2][now[2]]) {
                return now[1];
            }
            for (int next : new int[]{now[0] + 1, now[0] - 1, now[0] * 2}) {
                if(next < 0 || next > MAX || visited[(now[1] + 1) % 2][next]) continue;
                queue.add(new int[]{next, now[1] + 1, now[2] + now[1] + 1});
                visited[(now[1] + 1) % 2][next] = true;
            }
        }
        return -1;
    }
}