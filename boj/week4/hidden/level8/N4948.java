package boj.week4.hidden.level8;

import java.util.Scanner;

// 베르트랑 공준
public class N4948 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        while (N != 0) {
            int cnt = 0;
            for (int i = N+1; i <= 2 * N; i++) {
                if (isPrime(i)) cnt++;
            }
            sb.append(cnt + "\n");
            N = sc.nextInt();
        }
        System.out.print(sb.toString().trim());
    }
    static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i*i<=n; i++) if(n % i == 0) return false;
        return true;
    }
}
