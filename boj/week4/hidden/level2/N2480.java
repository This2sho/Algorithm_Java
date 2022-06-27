package boj.week4.hidden.level2;
import java.io.*;
import java.util.*;
// 주사위 세개
public class N2480 {
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        int cnt = map.values().stream().max(Integer::compareTo).get();
        if (cnt == 1) System.out.print(map.keySet().stream().max(Integer::compareTo).get() * 100);
        else if (cnt == 2) System.out.print(map.keySet().stream().filter(k -> map.get(k) == 2).findFirst().get() * 100 + 1000);
        else System.out.print(map.keySet().stream().filter(k -> map.get(k) == 3).findFirst().get() * 1000 + 10000);
    }
}
