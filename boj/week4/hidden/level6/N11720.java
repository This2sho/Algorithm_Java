package boj.week4.hidden.level6;

import java.util.Scanner;

// 숫자의 합
public class N11720 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] chars = sc.next().toCharArray();
        int sum = 0;
        for (char aChar : chars) sum += Character.getNumericValue(aChar);
        System.out.print(sum);
    }
}
