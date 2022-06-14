package boj.week3;
import java.util.Scanner;

// 사다리 조작
public class N15684 {
    static int N, M, H;
    static boolean[][] radder;
    static boolean[][] visited;
    static int res = 4;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        radder = new boolean[H][N];
        visited = new boolean[H][N];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            radder[a][b] = true;
        }
        solve(0, 0, 0);
        System.out.print(res == 4 ? -1 : res);
    }

    static void solve(int cnt, int startI, int startJ) {
        if(isValid()) {
            res = Math.min(res, cnt);
            return;
        }
        if(cnt >= 3) return;
        for (int i = startI; i < H; i++) {
            for (int j = i == startI? startJ : 0; j < N-1; j++) {
                if(!visited[i][j] && canAdd(i, j)){
                    radder[i][j] = true;
                    visited[i][j] = true;
                    solve(cnt + 1, i, j+1);
                    radder[i][j] = false;
                    visited[i][j] = false;
                }
            }
        }
    }

    static int go(int depth, int line) {
        if(depth == H) {
            return line;
        }
        if(radder[depth][line]) return go(depth + 1, line + 1);
        if(line-1 >= 0 && radder[depth][line-1]) return go(depth + 1, line - 1);
        return go(depth + 1, line);
    }

    static boolean canAdd(int depth, int line) {
        if(radder[depth][line] || line-1 >= 0 && radder[depth][line-1] || radder[depth][line+1]) return false;
        return true;
    }

    static boolean isValid() {
        for (int i = 0; i < N; i++) if(go(0, i) != i) return false;
        return true;
    }

    static void printMap() {
        int idx = 0;
        System.out.print("     ");
        for (int i = 0; i < radder[0].length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (boolean[] booleans : radder) {
            System.out.print(idx++ + "    ");
            for (int i=0; i<booleans.length; i++) {
                if(booleans[i]){
                    System.out.print("|__|  ");
                    i++;
                }else System.out.print("|  ");
            }
            System.out.println();
        }
    }
}
