package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

// 비밀번호 발음하기
public class N4659 {
    public static String moum = "aeiou";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String str = br.readLine();
        while(!str.equals("end")){
            System.out.println(isAcceptable(str));
            str = br.readLine();
        }
    }

    static String isAcceptable(String str) {
        boolean rule1 = false;
        int mCnt = 0, jCnt = 0;
        char rule3 = '1';

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(isMoum(c)){
                rule1 = true;
                mCnt++;
                jCnt = 0;
            }else{
                jCnt++;
                mCnt = 0;
            }
            if (mCnt >= 3 || jCnt >= 3) return "<" + str +">" + " is not acceptable.";

            if(c == rule3){
                if(c != 'e' && c != 'o') return "<" + str +">" + " is not acceptable.";
            }
            rule3 = c;
        }
        if(!rule1) return "<" + str +">" + " is not acceptable.";
        return "<" + str +">" + " is acceptable.";
    }

    private static boolean isMoum(char c) {
        return moum.indexOf(c) != -1;
    }
}
