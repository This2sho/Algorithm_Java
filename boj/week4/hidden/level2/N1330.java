package boj.week4.hidden.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 두 수 비교하기
public class N1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int compare = Integer.compare(A, B);
        if(compare > 0) System.out.print(">");
        else if(compare == 0) System.out.print("==");
        else System.out.print("<");
    }
}
