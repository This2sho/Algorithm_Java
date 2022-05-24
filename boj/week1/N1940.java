package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주몽
public class N1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] num = new int[10000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[Integer.parseInt(st.nextToken())] = 1;
        }

        int answer = 0;
        for (int i=0; i<num.length; i++) {
            if(num[i] < M && M-i != i && M-i >= 0 && num[M-i] == 1 && num[i] == 1 && M-i != i ){
                answer++;
                num[i] = num[M-i] = 0;
            }
        }
        System.out.println(answer);
    }
}
