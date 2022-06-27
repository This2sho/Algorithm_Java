package boj.week4.hidden.level4;
import java.io.*;
import java.util.StringTokenizer;
// 최소, 최대
public class N10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            min = Math.min(tmp, min);
            max = Math.max(tmp, max);
        }
        System.out.print(min + " "+ max);
    }
}
