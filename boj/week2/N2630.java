package boj.week2;

import java.util.Scanner;

// 색종이 만들기
public class N2630 {
    static int whitePaper, bluePaper = 0;
    static int[][] paper;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        makePaper(0, 0, N);
        System.out.println(whitePaper);
        System.out.println(bluePaper);
    }

    static void makePaper(int x, int y, int size) {
        if(isPossible(x, y, size)){
            if (paper[y][x] == 1) bluePaper++;
            else whitePaper++;
            return;
        }
        int newSize = size / 2;
        makePaper(x, y, newSize);
        makePaper(x + newSize, y, newSize);
        makePaper(x, y + newSize, newSize);
        makePaper(x+newSize, y + newSize, newSize);
    }

    static boolean isPossible(int x, int y, int size) {
        int value = paper[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if(value != paper[i][j]) return false;
            }
        }
        return true;
    }

}
