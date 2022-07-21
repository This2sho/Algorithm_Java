package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연산자 끼워넣기
public class N14888 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int[] op = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) op[i] = Integer.parseInt(st.nextToken());
        go(0, arr[0], op);
        System.out.print(max + "\n" + min);
    }

    static void go(int depth, int sum, int[] op) {
        if (depth == N - 1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(op[i] <= 0) continue;
            op[i]--;
            go(depth + 1, calculate(sum, arr[depth + 1], i), op);
            op[i]++;
        }
    }

    static int calculate(int a, int b, int op) {
        if(op == 0) return a+b;
        if(op == 1) return a-b;
        if(op == 2) return a*b;
        return a / b;
    }
}
