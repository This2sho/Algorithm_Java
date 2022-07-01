package boj.week4.hidden.level13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 네 번째 점
public class N3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arrX = new int[1001];
        int[] arrY = new int[1001];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            arrX[Integer.parseInt(st.nextToken())]++;
            arrY[Integer.parseInt(st.nextToken())]++;
        }
        for (int i=0; i< arrX.length; i++) if(arrX[i] == 1) System.out.print(i + " ");
        for (int i=0; i< arrY.length; i++) if(arrY[i] == 1) System.out.print(i);
    }
}
