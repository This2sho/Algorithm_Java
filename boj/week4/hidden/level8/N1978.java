package boj.week4.hidden.level8;

import java.io.*;
import java.util.StringTokenizer;

// 소수 찾기
public class N1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        while (N-- > 0) if(isPrime(Integer.parseInt(st.nextToken()))) cnt++;
        System.out.print(cnt);
    }

    private static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i*i<=n; i++) if(n % i == 0) return false;
        return true;
    }
}
