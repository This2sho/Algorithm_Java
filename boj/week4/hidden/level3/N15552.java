package boj.week4.hidden.level3;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

// 빠른 A+B
public class N15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = parseInt(st.nextToken());
            int B = parseInt(st.nextToken());
            bw.write(A+B+"\n");
        }
        bw.flush();
    }
}
