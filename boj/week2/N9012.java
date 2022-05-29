package boj.week2;

import java.util.Scanner;

// 괄호
public class N9012 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String string = sc.next();
            System.out.println(isValid(string));
        }
    }

    public static String isValid(String str) {
        int openCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') openCnt++;
            else openCnt--;

            if(openCnt < 0) return "NO";

        }
        if(openCnt == 0) return "YES";
        return "NO";
    }
}
