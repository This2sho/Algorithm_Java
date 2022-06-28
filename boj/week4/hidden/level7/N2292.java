package boj.week4.hidden.level7;

import java.util.Scanner;
// 벌집
public class N2292 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 1;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (N <= sum) {
                System.out.print(i);
                break;
            }
            sum += i*6;
        }
    }
}
