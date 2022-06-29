package boj.week4.hidden.level8;

import java.io.*;
import java.util.StringTokenizer;

// 소수 구하기
public class N1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = N; i <= M; i++) if(isPrime(i)) sb.append(i + "\n");
        System.out.print(sb.toString().trim());
    }
    private static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i*i<=n; i++) if(n % i == 0) return false;
        return true;
    }
}
