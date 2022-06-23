package boj.week4;
import java.io.*;
import java.util.*;

// 집합
public class N11723_bitmasking {
    static int set = 0;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            calculate(st.nextToken().charAt(0), st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0);
        }
        bw.flush();
    }

    static void calculate(char op, int n) throws IOException {
        if (op == 'a' && n != 0) {
            set |= 1 << n;
        } else if (op == 'r') {
            set &= ~(1 << n);
        } else if (op == 'c') {
            if((set & 1 << n) > 0) bw.write("1\n");
            else bw.write("0\n");
        } else if (op == 't') {
            set ^= 1 << n;
        } else if (op == 'a') {
            set = (1 << 21) -1;
        } else {
            set = 0;
        }
    }
}
