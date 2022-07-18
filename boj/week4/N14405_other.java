package boj.week4;

import java.util.Scanner;

// 피카츄
public class N14405_other {
    final static String PI = "pi";
    final static String KA = "ka";
    final static String CHU = "chu";
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        if(solve(S)) System.out.print("YES");
        else System.out.print("NO");
    }

    static boolean solve(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(i < s.length()-1 && s.startsWith(PI, i) || s.startsWith(KA, i)) i++;
            else if(i < s.length() - 2 && s.startsWith(CHU, i)) i+=2;
            else return false;
        }
        return true;
    }
}