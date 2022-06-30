package boj.week4.hidden.level11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 소트인사이드
public class N1427 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.next().toCharArray();
        int[] arr = new int[chars.length];
        for (int i = 0; i < chars.length; i++) arr[i] = Character.getNumericValue(chars[i]);
        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).forEach(a -> System.out.print(a));
    }
}
