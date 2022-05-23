package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

// 힌국이 그리울 땐 서버에 접속하지
public class N9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = parseInt(br.readLine());
        String[] split = br.readLine().split("\\*");

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            if(temp.startsWith(split[0])){
                temp = temp.substring(split[0].length());
                if(temp.endsWith(split[1])) System.out.println("DA");
                else System.out.println("NE");
            }
            else System.out.println("NE");
        }
    }
}
