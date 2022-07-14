package boj.week5;
import java.io.*;
import java.util.*;

// 뱀
public class N3190 {
    static int[][] map;
    static Queue<Pos> queue = new LinkedList<>();
    static int N;
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.add(new Pos(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0) == 'L' ? 0 : 1));
        }
        Snake snake = new Snake(new Pos(0, 0), 0);
        map[0][0] = -1;
        int time = 0;
        while (true) {
            time++;
            if(!queue.isEmpty()){
                Pos next = queue.peek();
                if(next.y+1 == time) {
                    snake.changeDirection(next.x);
                    queue.poll();
                }
            }
            if(!snake.move()) break;
        }
        System.out.print(time);
    }

    static class Snake{
        LinkedList<Pos> body = new LinkedList<>();
        int direction; // 오른쪽 : 0 , 아래 : 1, 왼쪽 : 2, 위 : 3

        public Snake(Pos head, int direction) {
            this.body.addLast(head);
            this.direction = direction;
        }

        public void changeDirection(int direction) {
            if (direction == 0) this.direction = (this.direction + 3) % 4;
            else this.direction = (this.direction + 1) % 4;
        }

        public boolean move() {
            int ny = body.peekLast().y + dy[direction];
            int nx = body.peekLast().x + dx[direction];
            if(ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == -1) return false;
            body.offer(new Pos(ny, nx));
            if(map[ny][nx] != 1) {
                Pos poll = body.poll();
                map[poll.y][poll.x] = 0;
            }
            map[ny][nx] = -1;
            return true;
        }
    }

    static class Pos{
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
