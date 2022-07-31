package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 비밀번호 찾기
public class N17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            map.put(s[0], s[1]);
        }
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            sb.append(map.get(s) + "\n");
        }
        System.out.print(sb.toString().trim());
    }
}
