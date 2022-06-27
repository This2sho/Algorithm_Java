package boj.week4.hidden.level3;

import java.io.*;
import java.util.StringTokenizer;

// A+B-5
public class N10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A= Integer.parseInt(st.nextToken());
        int B =Integer.parseInt(st.nextToken());
        while (A != 0 && B !=0){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            bw.write(A + B + "\n");
        }
        bw.flush();
    }
}
