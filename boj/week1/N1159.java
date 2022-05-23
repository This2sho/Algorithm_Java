package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class N1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = parseInt(br.readLine());
        int[] cnt = new int[26];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            cnt[s.charAt(0) - 'a']++;
        }
        boolean check = false;
        for(int i=0; i<cnt.length; i++){
            if(cnt[i] < 5) continue;
            check = true;
            System.out.print((char) (i + 'a'));
        }
        if(!check) System.out.print("PREDAJA");

    }
}
