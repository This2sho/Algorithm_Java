package boj.week4.hidden.level6;

import java.util.Scanner;

// 상수
public class N2908 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String rA = new StringBuffer(sc.next()).reverse().toString();
        String rB = new StringBuffer(sc.next()).reverse().toString();
        System.out.print((rA + rB).compareTo(rB + rA) > 0 ? rA : rB);
    }
}
