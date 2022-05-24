package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

// 1
public class N4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String temp = "";
        while ((temp = br.readLine()) != null && !temp.equals("")) {
            int n = Integer.parseInt(temp);
            int m = 1;
            int cnt = 1;
            while (m % n != 0) {
                m %= n;
                m = (m * 10) + 1;
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}