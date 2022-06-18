package boj;

import java.io.*;
import java.util.StringTokenizer;

//달팽이는 올라가고 싶다
public class N2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int res = (int) Math.ceil((double) (V-B) / (A-B));


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}
