package boj.week4.hidden.level3;
import java.io.*;
import java.util.StringTokenizer;

// A+B-4
public class N10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;
        while( (str=br.readLine()) != null){
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
        }
        System.out.print(sb);
    }
}