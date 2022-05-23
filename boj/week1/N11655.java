package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

// ROT13
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
// A B C D E F G H I J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
public class N11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s = br.readLine();
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            int small = s.charAt(i) - 'a';
            int big = s.charAt(i) - 'A';

            if(small >= 0 && small < 26){
                char change = (char) ((small + 13) % 26 + 'a');
                answer += change;
                continue;
            }

            if(big >= 0 && big < 26){
                char change = (char) ((big + 13) % 26 + 'A');
                answer += change;
                continue;
            }

            answer += s.charAt(i);
        }

        System.out.println(answer);
    }
}
