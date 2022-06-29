package boj.week4.hidden.level8;

import java.util.Scanner;

// 소인수분해
public class N11653 {
    static StringBuffer sb = new StringBuffer();;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        solve(N);
        System.out.print(sb.toString().trim());
    }

    static void solve(int n) {
        if(n==1) return;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                sb.append(i + "\n");
                solve(n / i);
                return;
            }
        }
    }

}
