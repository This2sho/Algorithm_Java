package boj.week4.hidden.level2;

import java.util.Scanner;

// 윤년
public class N2753 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N % 4 == 0 && N % 100 != 0|| N % 400 ==0) System.out.print(1);
        else System.out.print(0);
    }
}
