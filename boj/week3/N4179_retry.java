package boj.week3;
import java.util.*;
// 불!
public class N4179_retry {
    static int R, C;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static Queue<Position> jQueue = new LinkedList<>();
    static Queue<Position> fQueue = new LinkedList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String next = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = next.charAt(j);
                if(map[i][j] == 'J'){
                    jQueue.add(new Position(i, j, 0));
                    map[i][j] = '.';
                }else if(map[i][j] == 'F') fQueue.add(new Position(i, j, 0));
            }
        }

        int result = -1;
        out : while (true) {
            int fSize = fQueue.size();
            for (int i = 0; i < fSize; i++) {
                Position firePos = fQueue.poll();
                fire(firePos);
            }
            int jSize = jQueue.size();
            for (int i = 0; i < jSize; i++) {
                Position jihun = jQueue.poll();
                result = BFS(jihun);
                if(result != -1) break out;
            }
            if(jQueue.isEmpty()) break;
        }

        if(result != -1) System.out.print(result);
        else System.out.print("IMPOSSIBLE");
    }

    static void printMap() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    static class Position{
        int y, x, time;

        public Position(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static int BFS(Position pos) {
        int y = pos.y;
        int x = pos.x;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny <0 || ny >=R || nx <0 || nx >=C) return pos.time + 1;

            if(map[ny][nx] == '.'){
                map[ny][nx] = 'J';
                jQueue.add(new Position(ny, nx, pos.time + 1));
            }
        }
        return -1;
    }

    static void fire(Position pos) {
        int y = pos.y;
        int x = pos.x;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny <0 || ny >=R || nx <0 || nx >=C) continue;
            if(map[ny][nx] == '.' || map[ny][nx] == 'J'){
                map[ny][nx] = 'F';
                fQueue.add(new Position(ny, nx, pos.time + 1));
            }
        }
    }
}
