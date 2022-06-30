package boj.week4.hidden.level12;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 문자열 집합
public class N14425 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Set<String> set = new HashSet<>();
        while(N-- > 0) set.add(sc.next());
        int cnt = 0;
        while(M-- > 0) if(set.contains(sc.next())) cnt++;
        System.out.print(cnt);
    }
}
