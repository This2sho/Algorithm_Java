package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

// 패션왕 신해빈
public class N9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int n = parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String[] split = br.readLine().split(" ");
                map.put(split[1], map.getOrDefault(split[1], 0) + 1);
            }
            System.out.println(map.keySet().stream().map(s -> map.get(s) + 1)
                    .reduce(1, (a, b) -> a * b) - 1);
        }
    }
}
