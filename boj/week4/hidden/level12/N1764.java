package boj.week4.hidden.level12;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 듣보잡
public class N1764 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        while(N-- > 0) set.add(sc.next());
        while (M-- > 0) {
            String next = sc.next();
            if (set.contains(next)) res.add(next);
        }
        res.stream().sorted().forEach(a -> sb.append(a + "\n"));
        System.out.println(res.size());
        System.out.print(sb.toString().trim());
    }
}
