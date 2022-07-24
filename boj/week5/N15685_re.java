package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 드래곤 커브
public class N15685_re {
    static boolean[][] map = new boolean[101][101];
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dragon(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int res = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) res++;
            }
        }
        System.out.print(res);
    }

    static void dragon(int x, int y, int d, int g) {
        List<Integer> dList = new ArrayList<>();
        dList.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = dList.size() - 1; j >= 0; j--) {
                dList.add((dList.get(j) + 1) % 4);
            }
        }

        map[y][x] = true;
        for (Integer integer : dList) {
            x += dx[integer];
            y += dy[integer];
            map[y][x] = true;
        }
    }
}
