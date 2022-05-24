package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

// 팰린드롬 만들기
public class N1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s = br.readLine();
        int[] alp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alp[s.charAt(i) - 'A']++;
        }

        // 홀수가 두개 이상 들어있으면 탈락
        // 길이가 짝수인데 홀 수 가 있으면 탈락
        int oddCnt = 0;
        for (int i : alp) {
            if(i % 2 == 1) oddCnt++;
            if(oddCnt >= 2){
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }
        if(s.length() % 2 == 0 && oddCnt >=1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 만들 수 있다고 가정
        // 알파벳 순으로 앞에다 붙인다. /2 한거 그리고 끝에 마지막으로 리버스해서 붙인다.
        String answer = "";
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alp[i]/2; j++) {
                answer += (char) (i +'A');
            }
            alp[i] %= 2;
        }
        String end = new StringBuffer(answer).reverse().toString();
        for (int i=0; i < 26; i++) {
            if(alp[i]==1){
                answer += (char) (i +'A');
                break;
            }
        }
        System.out.println(answer + end);
    }
}
