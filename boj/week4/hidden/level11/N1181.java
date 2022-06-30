package boj.week4.hidden.level11;

import java.util.Arrays;
import java.util.Scanner;

// 단어 정렬
public class N1181 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        String[] arr = new String[N];
        while (N-- > 0) arr[N] = sc.next();
        Arrays.stream(arr).sorted((a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            else return a.length() - b.length();
        }).distinct().forEach(a -> sb.append(a + "\n"));
        System.out.print(sb.toString().trim());
    }
}
