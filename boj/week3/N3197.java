package boj.week3;
import java.util.*;
// 백조의 호수
public class N3197 {
    static char[][] map;
    static int[][] lPos = new int[2][2];
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static boolean[][] wVisited, lVisited;
    static Queue<int[]> waterQ = new LinkedList<>();
    static Queue<int[]> lQ = new LinkedList<>();
    static int R,C;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        wVisited = new boolean[R][C];
        lVisited = new boolean[R][C];
        int idx = 0;

        for (int i = 0; i < R; i++) {
            String next = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = next.charAt(j);
                if(map[i][j] == '.'){
                    waterQ.add(new int[]{i, j});
                    wVisited[i][j] = true;
                }
                else if(map[i][j] == 'L') {
                    waterQ.add(new int[]{i, j});
                    if(idx == 0) lVisited[i][j] = true;
                    lPos[idx][0] = i;
                    lPos[idx++][1] = j;
                }
            }
        }

        lQ.offer(new int[]{lPos[0][0], lPos[0][1]});
        int cnt = 0;
        while(!isMeet()){
            cnt++;
            melt();
        }
        System.out.print(cnt);
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

    static void print() {
        for (boolean[] chars : lVisited) {
            for (boolean aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isMeet() {
        boolean[][] visitX = new boolean[R][C];
        Queue<int[]> temp = new LinkedList<>();
        while(!lQ.isEmpty()){
            int[] poll = lQ.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];
                if (isValid(ny, nx, lVisited) || visitX[ny][nx]) continue;
                if(map[ny][nx] != 'X'){
                    lVisited[ny][nx] = true;
                    lQ.add(new int[]{ny, nx});
                } else{
                    visitX[ny][nx] = true;
                    temp.add(new int[]{poll[0], poll[1]});
                }
            }
        }
        lQ = temp;
        if(lVisited[lPos[1][0]][lPos[1][1]]) return true;
        return false;
    }

    static void melt() {
        int size = waterQ.size();
        for(int s = 0; s<size; s++){
            int[] poll = waterQ.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];
                if (isValid(ny, nx, wVisited) || map[ny][nx] != 'X') continue;
                wVisited[ny][nx] = true;
                map[ny][nx] = '.';
                waterQ.add(new int[]{ny, nx});
            }
        }
    }

    private static boolean isValid(int ny, int nx, boolean[][] visited) {
        return ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx];
    }
}
