package boj.week3;
import java.util.*;

public class N4179_resolve {
    static int R, C;
    static char[][] map;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static Queue<Integer[]> personQ = new LinkedList<>();
    static Queue<Integer[]> fireQ = new LinkedList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'J') personQ.add(new Integer[] {i, j, 0});
                else if(map[i][j] == 'F') fireQ.add(new Integer[] {i, j});
            }
        }
        int result = -1;
        out : while (true) {
            int fSize = fireQ.size();
            for (int i = 0; i < fSize; i++) {
                Integer[] poll = fireQ.poll();
                fireSpread(poll);
            }

            int pSize = personQ.size();
            for (int i = 0; i < pSize; i++) {
                Integer[] poll = personQ.poll();
                result = escape(poll);
                if(result != -1) break out;
            }
            if(personQ.isEmpty()) break;
        }
        if(result == -1) System.out.print("IMPOSSIBLE");
        else System.out.print(result);

    }

    static void printMap() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int escape(Integer[] pos) {
        for (int i = 0; i < 4; i++) {
            int ny = pos[0] + dy[i];
            int nx = pos[1] + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C) return pos[2] + 1;
            if(map[ny][nx] != '.') continue;
            map[ny][nx] = 'J';
            personQ.add(new Integer[]{ny, nx, pos[2] + 1});
        }
        return -1;
    }

    static void fireSpread(Integer[] pos) {
        for (int i = 0; i < 4; i++) {
            int ny = pos[0] + dy[i];
            int nx = pos[1] + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
            if(map[ny][nx] != '.' && map[ny][nx] != 'J') continue;
            map[ny][nx] = 'F';
            fireQ.add(new Integer[]{ny, nx});
        }
    }
}
