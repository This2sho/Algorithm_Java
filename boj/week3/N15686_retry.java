package boj.week3;
import java.util.*;

// 치킨 배달
public class N15686_retry {
    static int N, M;
    static int[][] map;
    static int chickenStreet = 0;
    static int answer = Integer.MAX_VALUE;

    static List<Pos> home = new LinkedList<>();
    static List<Pos> chicken = new LinkedList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) home.add(new Pos(j, i));
                else if(map[i][j] == 2) chicken.add(new Pos(j, i));
            }
        }
        boolean[] selected = new boolean[chicken.size()];
        DFS(selected, 0, 0);
        System.out.print(answer);
    }

    static class Pos{
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void DFS(boolean[] selected, int start, int num) {
        if(num == M){
            for (Pos pos : home) {
                int temp = Integer.MAX_VALUE;
                for (int i = 0; i < selected.length; i++) {
                    if(selected[i]){
                        Pos ch = chicken.get(i);
                        temp = Math.min(getDistance(pos.x, pos.y , ch.x, ch.y), temp);
                    }
                }
                chickenStreet += temp;
            }
            answer = Math.min(answer, chickenStreet);
            chickenStreet = 0;
            return;
        }

        for (int i = start; i < selected.length; i++) {
            selected[i] = true;
            DFS(selected,i+1, num+1);
            selected[i] = false;
        }
    }
}
