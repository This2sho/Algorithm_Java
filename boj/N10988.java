package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

// 팰린드롬인지 확인하기
public class N10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s = br.readLine();
        StringBuffer sb = new StringBuffer(s);
        String reverse = sb.reverse().toString();

        if(reverse.equals(s)) System.out.print(1);
        else System.out.print(0);
    }
}
