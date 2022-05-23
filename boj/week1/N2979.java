package boj.week1;

import java.util.Scanner;

import static java.lang.System.in;

// 트럭주차
public class N2979 {
    public static void main(String[] args){
        Scanner sc = new Scanner(in);
        int[] payInfo = new int[4];

        for (int i = 1; i < 4; i++) payInfo[i] = sc.nextInt();

        int[] count = new int[101];

        for (int i = 0; i < 3; i++) {
            int begin = sc.nextInt();
            int end = sc.nextInt();
            for (; begin < end; begin++) {
                count[begin]++;
            }
        }

        int sum = 0;
        for (int n : count) sum += n * payInfo[n];

        System.out.print(sum);
    }
}
/**
 * 1 2 3 4 5 6
 *     3 4 5
 *   2 3 4 5 6 7 8
 *  5 6 3 3 6 5 5
 */