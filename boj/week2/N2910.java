package boj.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 빈도 정렬
public class N2910 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); sc.nextInt();
        int arr[] = new int[N];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            cnt.put(arr[i], cnt.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.stream(arr).boxed().sorted((a, b) -> {
            a = cnt.get(a);
            b = cnt.get(b);
            return b.compareTo(a);
        }).distinct().forEach(n -> {for (int i = 0; i < cnt.get(n); i++) System.out.print(n + " ");});
    }
}
