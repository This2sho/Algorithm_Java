package boj.week4.hidden.level6;

import java.util.Scanner;

// 다이얼
public class N5622 {
 public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     int[] ar = new int[26];
     int cnt = 3, idx = 0, sum = 0;
     for (int i = 2; i < 10; i++) {
         int n = (i == 7 || i == 9) ? 4 : 3;
         for(int j=0; j < n; j++, idx++) ar[idx] = cnt;
         cnt++;
     }
     char[] chars = sc.next().toCharArray();
     for (char aChar : chars) sum += ar[aChar - 'A'];
     System.out.print(sum);
 }
}
