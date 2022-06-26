package boj.week4;

import java.util.Scanner;

// 피카츄
public class N14405 {
    final static int PI = 'p' + 'i';
    final static int KA = 'k' + 'a';
    final static int CHU = 'c' + 'h' + 'u';
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        if(solve(S)) System.out.print("YES");
        else System.out.print("NO");
    }

    static boolean solve(String s) {
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == 'p' || cur == 'k') {
                if(i+1 >= s.length()) return false;
                int tmp = cur + s.charAt(++i);
                if(tmp != PI && tmp != KA) return false;
            }else if(cur == 'c'){
                if(i+2 >= s.length()) return false;
                int tmp = cur + s.charAt(++i) + s.charAt(++i);
                if(tmp != CHU) return false;
            }else return false;
        }
        return true;
    }
}
