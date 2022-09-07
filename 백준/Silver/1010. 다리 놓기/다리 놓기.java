import java.io.*;
import java.util.StringTokenizer;
// 다리 놓기
public class Main {
    static int[][] cache = new int[31][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(combination(b, a) + "\n");
        }
        System.out.print(sb);
    }

    static int combination(int n, int m) {
        if(n == 1 || n == m || m == 0) cache[n][m] = 1;
        if(m == 1) cache[n][m] = n;
        if(cache[n][m] != 0) return cache[n][m];
       
        cache[n][m] = combination(n - 1, m) + combination(n - 1, m - 1);
        return cache[n][m];
    }
}