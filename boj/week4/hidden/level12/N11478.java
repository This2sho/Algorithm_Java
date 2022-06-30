package boj.week4.hidden.level12;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 서로 다른 부분 문자열의 개수
public class N11478 {
    static char[] chars;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        chars = sc.next().toCharArray();
        solve(0, 0, "");
        System.out.print(set.size());
    }

    static void solve(int start, int depth, String res) {
        if(start+depth >= chars.length) return;
        for (int i = 0; i < chars.length && depth==0; i++) {
            set.add(res + chars[i]);
            solve(i, depth+1, res+chars[i]);
        }
        set.add(res + chars[start+depth]);
        solve(start, depth+1, res+chars[start+depth]);
    }
}
