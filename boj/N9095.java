package boj;

import java.util.Scanner;

// 1,2,3 더하기
public class N9095 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] cache = new int[11];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 4;

        while (T-- > 0) {
            int n = sc.nextInt();
            for (int i = 4; i <= n; i++) cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
            System.out.println(cache[n]);
        }
    }
}
