package boj.week4.hidden.level4;

import java.util.Scanner;

// 숫자의 개수
public class N2577 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] ar = new int[3];
        int[] cnt = new int[10];
        for (int i = 0; i < 3; i++) ar[i] = sc.nextInt();
        String tmp = ar[0] * ar[1] * ar[2] + "";
        for (int i = 0; i < tmp.length(); i++) cnt[Character.getNumericValue(tmp.charAt(i))]++;
        for (int i : cnt) System.out.println(i);
    }
}
