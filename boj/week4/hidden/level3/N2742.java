package boj.week4.hidden.level3;

import java.io.*;
import java.util.StringTokenizer;

// 기찍 N
public class N2742 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) + 1;
        while (N-- > 1) {
            bw.write(N+"\n");
        }
        bw.flush();
    }
}
