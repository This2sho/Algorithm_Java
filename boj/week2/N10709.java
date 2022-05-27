package boj.week2;

import java.util.Arrays;
import java.util.Scanner;

// 기상캐스터
public class N10709 {
    static int[] answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        answer = new int[M];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            System.out.println(predict(str));
        }
    }

    static String predict(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'c') answer[i] = 0;
            else{
                if(i==0) answer[i] = -1;
                else if(answer[i-1] == -1) answer[i] = -1;
                else answer[i] = answer[i - 1] + 1;
            }
        }
        Arrays.stream(answer).forEach(n -> sb.append(n + " "));
        return sb.toString();
    }
}
