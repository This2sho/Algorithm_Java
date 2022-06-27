package boj.week4.hidden.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 더하기 사이클
public class N1110 {
    static int N;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        cycle(N);
        System.out.print(cnt);
    }

    static int cycle(int n) {
        if(cnt != 0 && n == N) return cnt;
        if (n < 10) {
            n = n*10 + n;
        }else{
            int right = (n / 10) + (n % 10);
            n = (n % 10) * 10 + right%10;
        }
        cnt++;
        return cycle(n);
    }
}
