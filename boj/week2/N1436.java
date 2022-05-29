package boj.week2;

import java.util.Scanner;

// 영화감독 숀
public class N1436 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        for (int i = 666; N > 0; i++) {
            String n = Integer.toString(i);
            if(n.contains("666")) {
                N--;
                answer = i;
            }
        }
        System.out.print(answer);
    }
}
