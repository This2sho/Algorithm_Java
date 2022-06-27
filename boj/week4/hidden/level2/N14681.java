package boj.week4.hidden.level2;

import java.util.Scanner;

// 사분면 고르기
public class N14681 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        boolean xP = x > 0;
        boolean yP = y > 0;

        if(xP && yP) System.out.print(1);
        else if(!xP && yP) System.out.print(2);
        else if(!xP && !yP) System.out.print(3);
        else System.out.print(4);
    }
}
