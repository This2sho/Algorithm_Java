package boj.week4.hidden.level8;

import java.io.IOException;
import java.util.Scanner;

// 소수
public class N2518 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int cnt = 0;
        int m = -1;
        for(int i = N; i<=M; i++){
            if (isPrime(i)){
                cnt+= i;
                if(m==-1) m = i;
            }
        }
        if(cnt != 0) System.out.print(cnt +"\n" + m);
        else System.out.print(-1);
    }

    private static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i*i<=n; i++) if(n % i == 0) return false;
        return true;
    }
}
