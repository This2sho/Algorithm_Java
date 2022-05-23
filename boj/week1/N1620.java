package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> name_map = new HashMap();
        HashMap<Integer, String> num_map = new HashMap();

        for (int i = 1; i <= N; i++) {
            String s = in.readLine();
            name_map.put(s, i);
            num_map.put(i, s);
        }
        for (int i = 0; i < M; i++) {
            String s = in.readLine();
            if(name_map.containsKey(s)) System.out.println(name_map.get(s));
            else System.out.println(num_map.get(Integer.parseInt(s)));
        }

    }
}
