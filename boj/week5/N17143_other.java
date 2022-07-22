package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 낚시왕
public class N17143_other {
    static int R,C,M;
    static int[][] map;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};
    static Shark[] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        s = new Shark[M+1];
        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            map[y][x] = i;
            s[i] = new Shark(y, x, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
        }
        int res = 0;

        for (int j = 0; j < C; j++) {
            res += getShark(j);
            for (int i = 1; i <= M; i++) {
                if(s[i] == null) continue;
                s[i].move();
            }
            changeMap();
        }

        System.out.print(res);
    }

    static void printMap() {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    static class Shark{
        int speed;
        int direction;
        int size;
        int y;
        int x;

        public Shark(int y, int x, int speed, int direction, int size) {
            this.y = y;
            this.x = x;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }

        public void move() {
            int ny = y;
            int nx = x;

            for (int i = speed; i > 0; i--) {
                ny += dy[direction];
                nx += dx[direction];
                if (ny >= R ||  nx < 0) {
                    direction--;
                    ny += dy[direction] * 2;
                    nx += dx[direction] * 2;
                }
                else if (ny < 0 || nx >= C) {
                    direction++;
                    ny += dy[direction] * 2;
                    nx += dx[direction] * 2;
                }
            }
            y = ny;
            x = nx;
        }
    }


    static int getShark(int j) {
        for (int i=0; i < R; i++) {
            if (map[i][j] != 0) {
                int size = s[map[i][j]].size;
                s[map[i][j]] = null;
                map[i][j] = 0;
                return size;
            }
        }
        return 0;
    }

    static void changeMap() {
        int[][] tmp = new int[R][C];
        for (int i = 1; i <= M; i++) {
            if(s[i] == null) continue;
            int r = s[i].y;
            int c = s[i].x;
            if(tmp[r][c] == 0) tmp[r][c] = i;
            else {
                if(s[i].size < s[tmp[r][c]].size) s[i] = null;
                else {
                    s[tmp[r][c]] = null;
                    tmp[r][c] = i;
                }
            }
        }
        map = tmp;
    }
}
