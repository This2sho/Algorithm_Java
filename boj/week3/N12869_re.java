package boj.week3;

import java.util.*;
// 뮤탈리스크
public class N12869_re {
    static int visited[][][] = new int[64][64][64];
    static Queue<Integer[]> queue = new LinkedList<>();
    final static int[][] attacks = new int[][]{{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] HP = new int[3];
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            HP[i] = sc.nextInt();
        }
        System.out.print(solve(HP[0], HP[1], HP[2]));
    }

    static int solve(int a, int b, int c) {
        queue.add(new Integer[] {a, b, c});
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            a = poll[0];
            b = poll[1];
            c = poll[2];
            if(visited[0][0][0] != 0) break;
            for (int i = 0; i < 6; i++) {
                int na = Math.max(0, a - attacks[i][0]);
                int nb = Math.max(0, b - attacks[i][1]);
                int nc = Math.max(0, c - attacks[i][2]);
                if(visited[na][nb][nc] != 0) continue;
                visited[na][nb][nc] = visited[a][b][c] + 1;
                queue.add(new Integer[]{na, nb, nc});
            }
        }
        return visited[0][0][0];
    }

}
