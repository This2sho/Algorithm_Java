package boj.week4.hidden.level3;

import java.io.*;
import java.util.StringTokenizer;

// A+B-7
public class N11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int i = 0;
        while (i++ != T) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write("Case #" + i + ": " + (A + B) + "\n");
        }
        bw.flush();
    }
}
