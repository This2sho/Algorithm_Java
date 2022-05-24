package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.System.in;

// 좋은 단어
public class N3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i ++){
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if(!stack.empty() && stack.peek().equals(s.charAt(j))) stack.pop();
                else stack.push(s.charAt(j));
            }
            if(stack.empty()) answer++;
        }
        System.out.print(answer);
    }
}
