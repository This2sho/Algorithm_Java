package boj.week4.hidden.level13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 직각삼각형
public class N4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pos = new int[3];
        for(int i =0; i<3; i++) pos[i] = (int) Math.pow(Integer.parseInt(st.nextToken()),2);
        while (pos[0] != 0 && pos[1] != 0 && pos[2] != 0) {
            int max = Arrays.stream(pos).max().getAsInt();
            int sum = Arrays.stream(pos).filter(a -> a!=max).sum();
            if(max == sum) sb.append("right\n");
            else sb.append("wrong\n");
            st = new StringTokenizer(br.readLine());
            for(int i =0; i<3; i++) pos[i] = (int) Math.pow(Integer.parseInt(st.nextToken()),2);
        }
        System.out.print(sb.toString().trim());
    }
}
