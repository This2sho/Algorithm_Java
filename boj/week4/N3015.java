package boj.week4;

import java.util.Scanner;
import java.util.Stack;

public class N3015 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Pair> stack = new Stack<>();
        int N = sc.nextInt();
        long  res = 0;
        for (int i = 0; i < N; i++) {
            int height = sc.nextInt();
            int cnt = 1;
            while(!stack.empty() && stack.peek().first <= height) {
                res += stack.peek().second;
                if (stack.peek().first == height) {
                    cnt = stack.peek().second + 1;
                }else cnt = 1;
                stack.pop();
            }
            if(!stack.isEmpty()) res++;
            stack.push(new Pair(height, cnt));
        }
        System.out.print(res);
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
