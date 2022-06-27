package boj.week4.hidden.level4;

import java.util.Scanner;

// 최댓값
public class N2562 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int idx = -1;
        int max = 0;
        for (int i = 1; i <= 9; i++) {
            int tmp = sc.nextInt();
            if(tmp > max){
                max = tmp;
                idx = i;
            }
        }
        System.out.print(max + "\n" + idx);
    }
}
