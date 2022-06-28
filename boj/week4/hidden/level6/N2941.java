package boj.week4.hidden.level6;

import java.util.Arrays;
import java.util.Scanner;

// 크로아티아 알파벳
public class N2941 {
    final static String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[8];
        String str = sc.next();
        for (int i = 0; i < 8; i++) {
            while (str.contains(cro[i])) {
                str = str.replaceFirst(cro[i], " ");
                cnt[i]++;
            }
        }
        System.out.print(Arrays.stream(cnt).sum() + str.replaceAll(" ", "").length());
    }
}
