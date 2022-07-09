package boj.week5;
import java.io.*;
import java.util.*;
// 미세먼지 안녕!
public class N17144 {
    static Queue<Pos> queue = new LinkedList<>();
    static int cleaner = -1;
    static int[][] map;
    static int R,C;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1 && cleaner == -1) cleaner = i;
            }
        }
        while (T-- > 0) {
            diffuse();
            moveAir();
        }
        System.out.print(getAnswer());
    }
    static class Pos{
        int y;
        int x;
        int dust;

        public Pos(int y, int x, int dust) {
            this.y = y;
            this.x = x;
            this.dust = dust;
        }
    }

    static void diffuse() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] >= 5) queue.add(new Pos(i, j, map[i][j]));
            }
        }
        int size = queue.size();
        for(int s=0; s < size; s++){
            Pos poll = queue.poll();
            int dust = poll.dust / 5;
            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];
                if(ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == -1) continue;
                map[poll.y][poll.x] -= dust;
                map[ny][nx] += dust;
            }
        }
    }

    static void moveAir() {
        int top = cleaner;
        int bottom = cleaner+1;
        // 아래
        for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        // 왼쪽
        for (int j = 0; j < C - 1; j++) map[0][j] = map[0][j + 1];
        // 위로
        for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1];
        // 오른쪽
        for (int j = C - 1; j > 1; j--) map[top][j] = map[top][j-1];
        map[top][1] = 0;

        // 위로
        for (int i = bottom + 1; i < R-1; i++) map[i][0] = map[i + 1][0];
        // 왼쪽
        for (int j = 0; j < C - 1; j++) map[R-1][j] = map[R-1][j+1];
        // 아래로
        for (int i = R-1; i > bottom; i--) map[i][C-1] = map[i-1][C - 1];
        // 오른쪽
        for (int j = C - 1; j > 1; j--) map[bottom][j] = map[bottom][j-1];
        map[bottom][1] = 0;
    }

    static int getAnswer() {
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer += map[i][j];
            }
        }
        return answer+2;
    }
}
