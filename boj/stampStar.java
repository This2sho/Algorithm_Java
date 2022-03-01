package boj;

import java.util.Scanner;

public class stampStar {

    static char[][] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        result = new char[N][N];

        initStar(0, 0, N, false);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void initStar(int x, int y, int N, boolean blank) {

        if (blank) {
            for (int i = x; i < x+N; i++) {
                for (int j = y; j < y+N; j++) {
                    result[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            result[x][y] = '*';
            return;
        }

        int size = N/3;
        int count = 0;

        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) initStar(i, j, size, true);
                else initStar(i, j, size, false);
            }
        }
    }

}


/**
 * 3일 때, 2,2 부분 삭제 (중심 : 2,2)
 * 9일 떄, 3일때를 그리고 2,2 부분 삭제
 * 27일 때, 9일때를 그리고 2,2 부분 삭제
 *
 * 블럭을 9개 단위로 나누고 5번 블럭의 경우 빈칸으로 채운다.
 * 블럭의 사이즈가 1이고 5번 블럭이 아닌 경우 *를 넣는다.
 */

