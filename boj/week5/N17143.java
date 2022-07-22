package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 낚시왕
public class N17143 {
    static int R,C,M;
    static Shark[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R][C];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            map[y][x] = new Shark(y, x, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
            queue.add(new int[]{y, x});
        }
        int res = 0;

        for (int j = 0; j < C; j++) {
            res += getShark(j);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                Shark curShark = map[poll[0]][poll[1]];
                if(curShark != null && !curShark.moved[j]) curShark.move(j);
            }
        }

        System.out.print(res);
    }

    static void printMap() {
        for (Shark[] sharks : map) {
            for (Shark shark : sharks) {
                if(shark != null) System.out.print(shark.size+ " ");
                else System.out.print(0 + " ");
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
        boolean[] moved;

        public Shark(int y, int x, int speed, int direction, int size) {
            this.y = y;
            this.x = x;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
            moved = new boolean[C];
        }

        public void move(int j) {
            map[y][x] = null;
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
            moved[j] = true;
            if(map[y][x] != null && !map[y][x].moved[j]) map[y][x].move(j);
            map[y][x] = max(map[y][x]);
            queue.add(new int[]{y, x});
        }

        public Shark max(Shark other) {
            if(other == null) return this;
            if(this.size > other.size) return this;
            return other;
        }
    }


    static int getShark(int j) {
        for (int i=0; i < R; i++) {
            if (map[i][j] != null) {
                int size = map[i][j].size;
                map[i][j] = null;
                return size;
            }
        }
        return 0;
    }
}
