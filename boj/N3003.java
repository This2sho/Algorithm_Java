package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 킹, 퀸, 룩, 비숍, 나이트, 폰
public class N3003 {
    static int[] res = {1, 1, 2, 2, 2, 8};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) sb.append((res[i] - Integer.parseInt(s[i])) + " ");
        System.out.print(sb);
    }
}
