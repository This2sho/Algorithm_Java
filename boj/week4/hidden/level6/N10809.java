package boj.week4.hidden.level6;

import java.util.Arrays;
import java.util.Scanner;

// 알파벳 찾기
public class N10809 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        char[] chars = sc.next().toCharArray();
        for (int i = 0; i < chars.length; i++) if(arr[chars[i] - 'a'] == -1) arr[chars[i] - 'a'] = i;
        for (int i : arr) System.out.print(i + " ");
    }
}
