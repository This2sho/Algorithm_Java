package boj.week4.hidden.level8;

import java.util.Scanner;

// 골드바흐의 추측
public class N9020 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        while (N-- > 0) {
            int n = sc.nextInt();
            for (int i = n/2; i >= 2; i--) {
                if (isPrime(i) && isPrime(n - i)) {
                    sb.append(i + " " + (n - i) + "\n");
                    break;
                }
            }
        }

        System.out.print(sb.toString().trim());
    }
    static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i*i<=n; i++) if(n % i == 0) return false;
        return true;
    }
}
