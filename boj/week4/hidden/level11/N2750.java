package boj.week4.hidden.level11;

import java.util.Arrays;
import java.util.Scanner;

// 수 정렬하기
public class N2750 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        while (N-- > 0) arr[N] = sc.nextInt();
        Arrays.stream(arr).sorted().forEach(a -> System.out.println(a));
    }
}
